#include <iostream>
#include <vector>
#include <stdio.h>

using namespace std;


int main()
{
    
    vector<int> student_n;
    int n, n_temp;
    cin >> n;
    for (int i=0; i<n; i++)
    {
        cin >> n_temp;
        int student = i+1;
        
        if(n_temp == 0) {student_n.push_back(student);}
        else 
        {
            int index = n - n_temp - 1;
            student_n.(student_n.begin() + index, student);
        }
    }
    
    for (vector<int>::iterator it=student_n.begin(); it!=student_n.end(); it++)
    {
      cout << *it << " ";
    }
    cout << endl;
}