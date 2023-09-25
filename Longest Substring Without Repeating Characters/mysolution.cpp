class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        set<char> set1;
        int end=0, start=0;
        
        int n=s.size();
        int ans=0;
        
        while(end<n)
        {
            char c=s[end];
            if(set1.find(c)!=set1.end())
            {
                ans=max(ans,end-start);
                while(set1.find(c)!=set1.end())
                {
                    char c1=s[start++];
                    set1.erase(c1);
                }
            }
            set1.insert(s[end++]);
        }
            
        ans=max(ans,end-start);
        
        return ans;
    }
};