class Solution {
public:
    string longestPalindrome(string s) {
        int n=s.size();
        
        if(n==1)
            return s;
        else if(n==2)
        {
            if(s[0]==s[1])
                return s;
            else
                return s.substr(0,1);
        }
        
        bool P[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                P[i][j]=false;
        
        string ans="";
        
        for(int i=0;i<n;i++)
        {
            P[i][i]=true;
            if(ans.size()<1)
                ans=s.substr(i,1);
        }
        
        // cout<<ans<<endl;
            
        for(int i=0;i<n-1;i++)
        {
            if(s[i]==s[i+1])
            {
                P[i][i+1]=true;
                if(ans.size()<2)
                    ans=s.substr(i,2);
            } 
        }
        
        // cout<<ans<<endl;
        
        for(int gap=2;gap<n;gap++)
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                if((s[i]==s[j])&&(P[i+1][j-1]))
                {
                    P[i][j]=true;
                    if(ans.size()<gap+1)
                        ans=s.substr(i,gap+1);
                }
            }
        
        return ans;
    }
};