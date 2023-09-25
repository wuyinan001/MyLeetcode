class Solution {
public:
    int countSubstrings(string s) {
        int n=s.size();
        
        int ans=n;
        
        vector<vector<bool>> P(n,vector<bool>(n,false));
        
        for(int i=0;i<n;i++)
            P[i][i]=true;
        
        for(int i=0;i<n-1;i++)
        {
            if(s[i]==s[i+1])
            {
                P[i][i+1]=true;
                ans++;
            }
        }
        
        for(int gap=2;gap<n;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                if(s[i]==s[j]&&P[i+1][j-1])
                {
                    P[i][j]=true;
                    ans++;
                }
            }
        }
        
        return ans;
    }
};