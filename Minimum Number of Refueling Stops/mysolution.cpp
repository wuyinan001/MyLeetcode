class Solution {
public:
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        int n=stations.size();
        int fuel=startFuel, prev=0;
        
        priority_queue<int,vector<int>> pq;
        int ans=0;
        
        for(auto stat:stations)
        {
            if(prev>=target)
                return ans;
            
            fuel+=prev-stat[0];
            
            //cout<<"fuel "<<fuel<<endl;
            
            while(fuel<0&&!pq.empty())
            {
                fuel+=pq.top();
                pq.pop();
                ans+=1;
            }
            
            if(fuel<0)
                return -1;
            
            prev=stat[0];
            pq.push(stat[1]);
        }
        
        prev+=fuel;
        
        while(prev<target&&!pq.empty())
        {
            prev+=pq.top();
            pq.pop();
            ans+=1;
        }
        
        if(prev>=target)
            return ans;
        else
            return -1;
    }
};