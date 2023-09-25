class Solution {
public:
    int characterReplacement(string s, int k) {
        int n=s.size();
        
        int maxfreq=0;
        map<char,int> freq;
        
        int ans=0, start=0, end=0;
        
        while(end<n)
        {
            char c=s[end];
            freq[c]++;
            maxfreq=max(maxfreq,freq[c]);
            
            if(end-start+1-maxfreq>k)
            {
                ans=max(ans,end-start);
                while(end-start+1-maxfreq>k)
                {
                    char c2=s[start++];
                    freq[c2]--;
                }
            }
            end++;
        }
        
        if(end-start-maxfreq<=k)
            ans=max(ans,end-start);
        
        return ans;
    }
};