#include <iostream>
#include <string>
#include <algorithm>
#include <map>

using namespace std;

int main ()
{
    int book_n;
    scanf("%d", &book_n);
    string book_name;
    map<string,int> table;

    for (int i=0; i<book_n; i++)
    {
        cin >> book_name;
        map<string,int>::iterator iter = table.find(book_name);
        // new
        if ( iter == table.end())
        {
            table.insert({book_name,1});
        }
        // already exist
        else 
        {
            iter->second++; 
        }
    }
    
    int max_book;
    map<string,int>::iterator max_iter = max_element(table.begin(), table.end(), [](const auto &x, const auto &y) {return x.second < y.second;});

    cout << max_iter->first << endl;
}