#include <iostream>
#include <list>
#include <string>
using namespace std;
int testcase;
int main ()
{
    scanf("%d", &testcase);
    for (int i=0; i<testcase; i++) {
        string key_log;
        cin >> key_log;

        list<char> secret;
        auto key_iter = secret.begin();

        for(int j=0; j<key_log.length(); j++) {
			
			if ((key_log[j] == '-') && (key_iter != secret.begin())) {
                key_iter = secret.erase(--key_iter);
            }
            else if ((key_log[j] == '<') && (key_iter != secret.begin())) {key_iter--;}
			else if ((key_log[j] == '>') && (key_iter != secret.end())) {key_iter++;}
			else if ((key_log[j] != '-') && (key_log[j] != '<') && (key_log[j] != '>')) {
                secret.insert(key_iter, key_log[j]);
            }        
        }
        
        for (auto it = secret.begin(); it != secret.end(); it++) {cout << *it;}
		cout << endl;
    }
}