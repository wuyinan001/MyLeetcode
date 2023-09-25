class Solution {
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        
        if(n==1)
            return nums[0];
            
        int ans=max(nums[0],nums[1]);
        vector<int> L(n,nums[0]);
        L[1]=max(nums[0],nums[1]);
            
        for(int i=2;i<n;i++)
        {
            L[i]=max(L[i-1],L[i-2]+nums[i]);
            ans=max(ans,L[i]);
        }
        
        return ans;
    }
};