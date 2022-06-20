#include <iostream>
#include <queue>
using namespace std;

int main ()
{
    int n, w, L, input;
    queue<int> truck_wait, truck_on_bridge, truck_time;
    
    cin >> n >> w >> L;
    
    for (int i=0; i<n; i++)
    {
        scanf("%d",&input);
        truck_wait.push(input);
    }

    int time = 0, sum_weight=0, truck_num_bridge = 0, not_fin = n;
    while (not_fin > 0) 
    {
        time++; 
        // truck out from bridge 
        if(!truck_time.empty())
        {
            if (truck_time.front() + w == time)
            {
                sum_weight -= truck_on_bridge.front();
                truck_on_bridge.pop();  
                truck_time.pop(); 
                truck_num_bridge--;
                not_fin--;
            }
        }
        
        // new truck in bridge
        if(!truck_wait.empty())
        {
            if((sum_weight + truck_wait.front() <= L) && (truck_num_bridge < w))
            {   
                sum_weight += truck_wait.front();
                truck_on_bridge.push(truck_wait.front()); // for remember weight
                truck_wait.pop(); // delete waitiing
                truck_time.push(time);
                truck_num_bridge++;
            }
        }
        // else move & wait
    } // empty wait, bridge

    printf("%d\n", time);
}