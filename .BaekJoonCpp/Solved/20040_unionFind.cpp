#include <iostream>
using namespace std;
# define max 500001

int dot_array[max];
int first_cycle = 0;

int main ()
{
    for (int i=0; i<max; i++) {dot_array[i] = -1;}
    int n, m, input1, input2;
    cin >> n >> m;
    for (int i=0; i<m; i++)
    {
        cin >> input1 >> input2;
        if ((dot_array[input1] >= 0) && (dot_array[input2] >= 0))
        {
            // check root1
            int root1 = input1, root2 = input2;
            while (root1 != dot_array[root1]) {root1 = dot_array[root1];}
            
            // check root2
            while(root2 != dot_array[root2]) {root2 = dot_array[root2];}
            // cycle
            if (root1 == root2) {first_cycle = i + 1; break;}
            // if not same merge to small num root 
            else if (root1 < root2) {dot_array[root2] = root1;} 
            else {dot_array[root1] = root2;}
        }
        else if (dot_array[input1] >= 0) {
            dot_array[input2] = input1;
        }
        else if (dot_array[input2] >= 0) {
            dot_array[input1] = input2;
        }
        else {
            // all new (small num is root)
            if(input1 < input2) {
                dot_array[input1] = input1;
                dot_array[input2] = input1;
            } else {
                dot_array[input2] = input2;
                dot_array[input1] = input2;
            }

        }
    }
    printf("%d\n", first_cycle);
}