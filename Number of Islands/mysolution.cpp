class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int n=grid.size(), m=grid[0].size();
        vector<vector<int>> dirs{{1,0},{-1,0},{0,1},{0,-1}};
        int ans=0;
        vector<pair<int,int>> queue;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //cout<<i<<" "<<j<<endl;
                if(grid[i][j]=='1')
                {
                    ans++;
                    grid[i][j]='0';
                    queue.push_back({i,j});
                    while(!queue.empty())
                    {
                        pair<int,int> p=queue[0];
                        queue.erase(queue.begin());
                        for(auto dir:dirs)
                        {
                            int x=p.first+dir[0], y=p.second+dir[1];
                            if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]=='1')
                            {
                                queue.push_back({x,y});
                                grid[x][y]='0';
                            }
                        }
                    }
                }
            }
        }
        
        return ans;    
    }
};