class Solution {
public:
    int n=0;
    
    int dp(vector<vector<int>>& grid, int row1, int row2, int col1, vector<vector<vector<int>>>& memo)
    {
        int col2=row1+col1-row2;
        if(row1>=n||row2>=n||col1>=n||col2>=n||grid[row1][col1]==-1||grid[row2][col2]==-1)
            return -9999;
        
        if(memo[row1][row2][col1]!=-9999)
            return memo[row1][row2][col1];
        
        int ans=grid[row1][col1];
        
        if(row1!=row2||col2!=col1)
            ans+=grid[row2][col2];
        
        int next=0;
        next=max(max(dp(grid,row1+1,row2+1,col1,memo),dp(grid,row1+1,row2,col1,memo)),\
                 max(dp(grid,row1,row2+1,col1+1,memo),dp(grid,row1,row2,col1+1,memo)));
        
        ans+=next;
        
        memo[row1][row2][col1]=ans;
        return ans;
    }
    
    void print(vector<vector<vector<int>>>& memo)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cout<<memo[i][j][i]<<" ";
            }
            cout<<endl;
        }
    }
        
    int cherryPickup(vector<vector<int>>& grid) {
        n=grid.size();
        vector<vector<vector<int>>> memo(n,vector<vector<int>>(n,vector<int>(n,-9999)));
        
        memo[n-1][n-1][n-1]=grid[n-1][n-1];
        
        int ans=dp(grid,0,0,0,memo);

        return max(ans,0);
    }
};