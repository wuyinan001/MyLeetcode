class Solution {
public:
    int minAddToMakeValid(string s) {
        int ans=0, n=s.size();
        int right=0;
        
        for(auto c:s)
        {
            if(c=='(')
                right-=1;
            else if(c==')')
                right+=1;
            
            if(right>0)
            {
                ans++;
                right--;
            }
        }
        
        if(right<0)
            ans+=abs(right);
        
        return ans;
    }
};