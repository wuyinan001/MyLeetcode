class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        vector<int> L(n,1);
        int ans=1;
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                    L[i]=max(L[i],1+L[j]);
            }
            
            ans=max(ans,L[i]);
        }
        
        return ans;
    }
};