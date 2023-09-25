class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        set<int> set;
        for(auto i:nums)
            set.insert(i);
        
        int ans=0;
        
        for(auto i:set)
        {
            if(set.find(i+1)!=set.end())
                continue;
            
            int curr=1;
            for(int j=i-1;set.find(j)!=set.end();j--)
            {
                curr++;
            }
            
            ans=max(ans,curr);
        }
        
        return ans;
    }
};