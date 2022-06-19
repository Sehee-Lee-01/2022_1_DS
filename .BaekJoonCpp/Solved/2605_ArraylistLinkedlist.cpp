#include <iostream>
#include <vector>

using namespace std;


int main()
{
    
    vector<int> student_n;
    int n, n_temp;
    scanf("%d", &n);
    for (int i=0; i<n; i++)
    {
        scanf("%d", &n_temp);
        int student = i+1;
        
        if(n_temp == 0) {student_n.push_back(student);}
        else 
        {
            int index = student -1 - n_temp;
            student_n.emplace(student_n.begin() + index, student);
        }
    }
    
    for (vector<int>::iterator it=student_n.begin(); it!=student_n.end(); it++)
    {
      printf("%d ",*it);
    }
    cout << endl;
}