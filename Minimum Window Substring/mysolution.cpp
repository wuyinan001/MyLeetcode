class Solution {
public:
    string minWindow(string s, string t) {
        map<char,int> dict1;
        map<char,int> dict2;
        
        for(auto c:t)
        {
            dict2[c]++;
        }
        
        string ans="";
        int start=0, end=0, meet=0, len=INT_MAX;
        int n=s.size();
        
        while(end<n)
        {
            char c=s[end];
            dict1[c]++;
            
            if(dict2.find(c)!=dict2.end()&&dict2[c]==dict1[c])
                meet++;
            
            if(meet==dict2.size())
            {
                while(meet==dict2.size())
                {
                    char c2=s[start++];
                    if(dict2.find(c2)!=dict2.end()&&dict2[c2]==dict1[c2])
                        meet--;
                    dict1[c2]--;
                }
                
                if(len>end-start+2)
                {
                    len=end-start+2;
                    ans=s.substr(start-1,len);    
                }
            }
            
            end++;
        }
        
        return ans;
    }
};