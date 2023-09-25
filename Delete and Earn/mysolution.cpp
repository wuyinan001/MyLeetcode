class Solution {
public:
    int dp(int i, map<int,int>& gain, vector<int>& memo)
    {
        if(memo[i]!=-1)
            return memo[i];
        
        int ans=0;
        
        if(i==0)
            ans=0;
        else if(i==1)
        {
            if(gain.find(i)==gain.end())
            {
                ans=0;
            }
            else
            {
                ans=gain[i];
            }
        }
        else
        {
            if(gain.find(i)==gain.end())
            {
                ans=dp(i-1,gain,memo);
            }
            else
            {
                ans=max(gain[i]+dp(i-2,gain,memo),dp(i-1,gain,memo));
            }
        }
        
        memo[i]=ans;
        return ans;
    }
    
    int deleteAndEarn(vector<int>& nums) {
        map<int,int> freq;
        map<int,int> gain;
        
        int n=nums.size();
        int max1=0;
        
        for(auto i:nums)
        {
            max1=max(max1,i);
            freq[i]++;
        }
        
        for(auto i:freq)
        {
            gain[i.first]=i.first*i.second;
        }
        
        vector<int> memo(max1+1,-1);
        
        return dp(max1,gain,memo);
    }
};