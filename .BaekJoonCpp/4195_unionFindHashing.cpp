#include <iostream>
#include <algorithm>
#include <map>
using namespace std;
int testcase, relation_n;
string name1, name2;

int main ()
{
    scanf("%d", &testcase);
    for (int i=0; i<testcase; i++) {
        map<string, string> relation;
        scanf("%d", &relation_n);
        for (int j=0; j<relation_n; j++) {
            cin >> name1 >> name2;
            auto  itroot1 = relation.end(), itroot2 = relation.end();
            bool it1_ex=false, it2_ex=false;
            int friend_n = 0;

            // find root if exist
            for (auto it = relation.begin(); it != relation.end(); ++it) {if (it->second == name1) { itroot1 = it; break;}}
            for (auto it = relation.begin(); it != relation.end(); ++it) {if (it->second == name2) { itroot2 = it; break;}}
            if (itroot1 != relation.end()) {it1_ex = true;}
            if (itroot2 != relation.end()) {it2_ex = true;}
            // two exist 
            if ((it1_ex)&&(it2_ex)) {
                if (itroot1->first == itroot2->first) {
                    friend_n = relation.count(itroot1->first);
                } else {
                    string itroot2_name = itroot2->first;
                    for (auto iter = relation.begin(); iter != relation.end(); iter++) {
                        if (iter->first == itroot2_name) {
                            relation.insert({itroot1->first, iter->second});
                            relation.erase(iter++);
                        }
                    }
                    friend_n = relation.count(itroot1->first);
                }
            }
            else if(it1_ex) {
                relation.insert({itroot1->first, name2});
                friend_n = relation.count(itroot1->first);

            }
            else if(it2_ex) {
                relation.insert({itroot2->first, name1});
                friend_n = relation.count(itroot2->first);

            }
            else { 
                relation.insert({name1, name2});
                relation.insert({name1, name1}); // root 
                friend_n = 2;
            }

            printf("%d\n", friend_n);
        }
    }
}