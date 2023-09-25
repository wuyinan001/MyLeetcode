class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int n=heights.size(), m=heights[0].size();
        
        vector<vector<bool>> P(n,vector<bool>(m,false));
        vector<vector<bool>> A(n,vector<bool>(m,false));
        
        vector<vector<int>> dirs{{1,0},{-1,0},{0,1},{0,-1}};
        
        vector<pair<int,int>> queue;
        
        for(int i=0;i<n;i++)
        {
            P[i][0]=true;
            queue.push_back({i,0});
        }
        
        for(int j=0;j<m;j++)
        {
            P[0][j]=true;
            queue.push_back({0,j});
        }
        
        while(!queue.empty())
        {
            pair<int,int> curr=queue[0];
            queue.erase(queue.begin());
            
            for(auto d:dirs)
            {
                int x=curr.first+d[0], y=curr.second+d[1];
                if(x>=0&&x<n&&y>=0&&y<m&&heights[x][y]>=heights[curr.first][curr.second]&&!P[x][y])
                {
                    queue.push_back({x,y});
                    P[x][y]=true;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            A[i][m-1]=true;
            queue.push_back({i,m-1});
        }
        
        for(int j=0;j<m;j++)
        {
            A[n-1][j]=true;
            queue.push_back({n-1,j});
        }
        
        while(!queue.empty())
        {
            pair<int,int> curr=queue[0];
            queue.erase(queue.begin());
            
            for(auto d:dirs)
            {
                int x=curr.first+d[0], y=curr.second+d[1];
                if(x>=0&&x<n&&y>=0&&y<m&&heights[x][y]>=heights[curr.first][curr.second]&&!A[x][y])
                {
                    queue.push_back({x,y});
                    A[x][y]=true;
                }
            }
        }
        
        vector<vector<int>> ans;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(P[i][j]&&A[i][j])
                    ans.push_back({i,j});
            }
        }
        
        return ans;
    }
};