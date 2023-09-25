class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        int n=board.size();
        bool right=true;
        map<int,pair<int,int>> map;
        int count=1;
        vector<vector<bool>> visited(n,vector<bool>(n,false));
        
        for(int i=n-1;i>=0;i--)
        {
            if(right)
            {
                for(int j=0;j<n;j++)
                {
                    map[count]={i,j};
                    count++;
                }
                right=false;
            }
            else
            {
                for(int j=n-1;j>=0;j--)
                {
                    map[count]={i,j};
                    count++;
                }
                right=true;
            }
        }
        
        vector<int> queue{1};
        visited[n-1][0]=true;
        int ans=0;
            
        while(!queue.empty())
        {
            int size=queue.size();
            
            // for(int j=0;j<size;j++)
            //     cout<<queue[j]<<" ";
            // cout<<endl;
            
            for(int j=0;j<size;j++)
            {
                int curr=queue[0];
            
                if(curr==n*n)
                    return ans;
                
                queue.erase(queue.begin());
                for(int i=1;i<=min(6,n*n-curr);i++)
                {
                    int v=i+curr;

                    pair<int,int> pos=map[v];
                    
                    if(!visited[pos.first][pos.second])
                    {
                        visited[pos.first][pos.second]=true;

                        if(board[pos.first][pos.second]!=-1)
                        {
                            queue.push_back(board[pos.first][pos.second]);
                        }
                        else
                            queue.push_back(v);
                    }
                }
            }
            
            ans++;
        }
        
        return -1;
    }
};