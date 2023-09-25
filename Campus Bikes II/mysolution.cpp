class Solution {
public:
    int ans=INT_MAX;
    vector<bool> visited;
    
    void backTrack(vector<vector<int>>& workers, vector<vector<int>>& bikes, int index, int total)
    {
        if(total>=ans)
            return;
        
        if(index==workers.size())
        {
            ans=min(ans,total);
            return;
        }
        
        for(int i=0;i<bikes.size();i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                int d=abs(workers[index][0]-bikes[i][0])+abs(workers[index][1]-bikes[i][1]);
                backTrack(workers,bikes,index+1,total+d);
                visited[i]=false;
            }
        }
    }
    
    int assignBikes(vector<vector<int>>& workers, vector<vector<int>>& bikes) {
        int n=workers.size(), m=bikes.size();
        
        for(int i=0;i<m;i++)
            visited.push_back(false);
        
        backTrack(workers,bikes,0,0);
        
        return ans;
    }
};