class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> L(m, vector<int> (n,1));
        
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                L[i][j]=L[i-1][j]+L[i][j-1];
            }
        }
        
        return L[m-1][n-1];
    }
};