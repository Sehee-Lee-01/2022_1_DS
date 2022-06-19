#include <iostream>
#include <queue>
#include <functional> 
using namespace std;

int main ()
{
    int n;
    scanf("%d", &n);
    priority_queue <int> present;
    
    for (int i=0; i<n; i++)
    {
        int present_n, presnent_v; 
        scanf("%d", &present_n);
        if(present_n > 0)
        {   for (int j=0; j<present_n; j++)
            {
                scanf("%d", &presnent_v);
                present.push(presnent_v);
            }
        }
        else
        {
            if(present.empty()) {cout << -1 << endl;}
            else 
            {
                cout << present.top() << endl;
                present.pop();
            }
        }

    }
}