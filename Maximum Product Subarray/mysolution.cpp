class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n=nums.size();
        
        vector<int> minP(n,0);
        vector<int> maxP(n,0);
        
        minP[0]=nums[0];
        maxP[0]=nums[0];
        
        int ans=nums[0];
        
        for(int i=1;i<n;i++)
        {
            if(nums[i]>=0)
            {
                maxP[i]=max(nums[i],maxP[i-1]*nums[i]);
                minP[i]=min(nums[i],minP[i-1]*nums[i]);
            }
            else
            {
                maxP[i]=max(nums[i],minP[i-1]*nums[i]);
                minP[i]=min(nums[i],maxP[i-1]*nums[i]);
            }
            
            ans=max(ans,maxP[i]);
        }
        
        return ans;
    }
};