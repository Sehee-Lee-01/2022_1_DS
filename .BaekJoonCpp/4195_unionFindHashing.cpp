#include <iostream>
#include <map>
#include <set>
# define MAX_SIZE 200002

using namespace std;

int sizes[MAX_SIZE];
int link[MAX_SIZE];

int find_root(int x) {
	if (link[x] == x) return x;
	return link[x] = find_root(link[x]);
}

void union_find(int a, int b) {
	a = find_root(a);
	b = find_root(b);
    
    if( a != b ){
		if (sizes[a] < sizes[b]) swap(a, b);
		sizes[a] += sizes[b];
		link[b] = a;
    }
}

int main() {

    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int tetcase, relation_n, root1, root2;
	cin >> tetcase;

	string name1, name2;

	for (int i=0; i<tetcase; i++) {
		cin >> relation_n;

		for (int j=0; j<MAX_SIZE; j++) {sizes[j] = 1; link[j] = j;}
		map<string, int> hash_map;
		int friend_n = 1;

		for (int j=0; j<relation_n; j++) {
			cin >> name1 >> name2;

			if (hash_map.count(name1) == 0) hash_map[name1] = friend_n++;		
			if (hash_map.count(name2) == 0) hash_map[name2] = friend_n++;
			
            union_find(hash_map[name1], hash_map[name2]);
            
            root1 = find_root(hash_map[name1]);
            root2 = find_root(hash_map[name2]);
            
            if(sizes[root1] > sizes[root2]) {cout << sizes[root1] << endl;}
            else {cout << sizes[root2] << endl;}
		}
	}
}