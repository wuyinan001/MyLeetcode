class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n=nums.size();
        
        int ans=nums[0], presum=nums[0];
        
        for(int i=1;i<n;i++)
        {
            if(presum>0)
            {
                presum+=nums[i];
            }
            else
            {
                presum=nums[i];
            }
            
            ans=max(ans,presum);
        }
        
        return ans;
    }
};