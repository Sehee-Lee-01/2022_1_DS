// 10989
#include <iostream>
using namespace std;
#define N 10001

int n_array[N]; // 10000 이하의 자연수

int main()
{   
    int n_count; // 수의 개수, 입력 수 temp
    int n_temp;
    scanf("%d", &n_count);
    
    for(int i=0; i<n_count; i++) {
        scanf("%d", &n_temp);
        n_array[n_temp]++; // 누적
    }    
    
    for(int i=0; i<N; i++)
        if(n_array[i])
            for(int j=0; j<n_array[i]; j++) 
			    printf("%d\n", i);
}