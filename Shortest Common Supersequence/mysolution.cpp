class Solution {
public:
    string shortestCommonSupersequence(string str1, string str2) {
        int n1=str1.size(), n2=str2.size();
        
        vector<vector<int>> L(n1+1,vector<int>(n2+1,0));
        
        for(int i=0;i<=n1;i++)
            L[i][0]=0;
        
        for(int j=1;j<=n2;j++)
            L[0][j]=0;
        
        for(int i=1;i<=n1;i++)
        {
            for(int j=1;j<=n2;j++)
            {
                if(str1[i-1]==str2[j-1])
                    L[i][j]=1+L[i-1][j-1];
                else
                    L[i][j]=max(L[i-1][j],L[i][j-1]);
            }
        }
        
        int i=n1-1, j=n2-1;
        vector<char> stack;
            
        while(i>=0&&j>=0)
        {
            if(str1[i]==str2[j])
            {
                stack.push_back(str1[i]);
                i-=1;
                j-=1;
            }
            else
            {
                if(L[i+1][j]>=L[i][j+1])
                {
                    stack.push_back(str2[j]);
                    j--;
                }
                else
                {
                    stack.push_back(str1[i]);
                    i--;
                }
            }
        }
        
        while(i>=0)
        {
            stack.push_back(str1[i]);
            i--;
        }
        
        while(j>=0)
        {
            stack.push_back(str2[j]);
            j--;
        }
        
        string ans="";
        
        for(auto c:stack)
        {
            ans=c+ans;
        }
        
        return ans;
    }
};