#include <iostream>
#include <stdio.h>
using namespace std;
# define ALPHA 26
// 0 = A, 1 = B ... 26 = Z
// btree_array[0] = {B, C}
int btree_array[ALPHA][2]; 

void preorder(int alpha = 0)
{
    if (alpha<0) return;
	printf("%c",alpha+65);
    preorder(btree_array[alpha][0]);
    preorder(btree_array[alpha][1]);
    return;
}
void inorder(int alpha = 0)
{
    if (alpha<0) return;
    inorder(btree_array[alpha][0]);
	printf("%c",alpha+65);
    inorder(btree_array[alpha][1]);
    return;
}
void postorder(int alpha = 0)
{
    if (alpha<0) return;
    postorder(btree_array[alpha][0]);
    postorder(btree_array[alpha][1]);
	printf("%c",alpha+65);
    return;
}


int main()
{
    int N;
    scanf("%d",&N);

    char temp1, temp2, temp3;
    for(int i=0; i<N; i++)
    {        
        cin >> temp1 >> temp2 >> temp3;
        if (temp2 == '.') btree_array[temp1-65][0] = -1;
        else 
        btree_array[temp1-65][0] = temp2 -65; // left
        if (temp3 == '.') btree_array[temp1-65][1] = -1;
        else 
        btree_array[temp1-65][1] = temp3 -65; // right
    }

    //Test
    
    preorder();
    printf("\n");
    inorder();
    printf("\n");
    postorder();
    printf("\n");
}