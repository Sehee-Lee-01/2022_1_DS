#include <iostream>
#include <vector>
#include<utility>
#include <algorithm>
#define MAX 100
using namespace std;

int map[MAX][MAX];
int visit[MAX][MAX];

int M, N, K;
pair<int, int> check_pair[4] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

int DFS(int y,int x);
int main() {
    ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    cin >> M >> N >> K;
    int le_do_x, le_do_y, ri_up_x, ri_up_y; 
    vector<int> visited_cell;
    
    // draw map
    for (int i=0; i<K; i++) {
        cin >> le_do_x >> le_do_y >> ri_up_x >> ri_up_y;
        for(int j=le_do_x; j<ri_up_x; j++) {for(int k=le_do_y; k<ri_up_y; k++) {map[k][j]=1;}}
    }
    for(int i=0;i<M;i++){
        for(int j=0; j<N; j++){
            if((!visit[i][j])&&(!map[i][j])){
                visit[i][j]=1;
                visited_cell.push_back(DFS(i,j));
            }
        }
    }
    cout << visited_cell.size()<< endl;
    sort(visited_cell.begin(),visited_cell.end());
    for(int i=0;i<visited_cell.size();i++) {cout << visited_cell[i] << " ";}
    cout << endl;
}

int DFS(int y,int x){
    int count = 1;
    for(int l=0; l<4; l++){
        int test_x = x + check_pair[l].second;
        int test_y = y + check_pair[l].first;
        
        if ((visit[test_y][test_x])||(map[test_y][test_x])) {continue;}
        else if((test_x<0)||(test_x>=N)||(test_y<0)||(test_y>=M)) {continue;}
        else {        
            visit[test_y][test_x] = 1;
            count += DFS(test_y,test_x);
        }
    }
    return count;
} 