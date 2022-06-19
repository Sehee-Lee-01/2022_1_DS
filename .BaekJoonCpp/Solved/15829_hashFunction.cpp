#include <iostream>
#include <cmath>
using namespace std;

#define M 1234567891
#define r 31

int main ()
{
    int n;
    scanf("%d", &n);

    char sentence[n+1];
    scanf("%s",sentence);

    unsigned long long hash = 0;
    for (int i=0; i<n; i++)
    {
        unsigned long long r_pow = 1;
        for (int j=0; j<i; j++){
            r_pow = (r_pow*r) % M;
        }
        hash += r_pow*(sentence[i] - 96) % M;
    }

    hash = hash % M;

    cout << hash << endl; 
}