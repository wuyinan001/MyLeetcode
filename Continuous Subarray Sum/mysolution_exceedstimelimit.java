class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n=nums.length;
        int[] presum=new int[n+1];
        
        for(int i=1;i<=n;i++)
            presum[i]=presum[i-1]+nums[i-1];
        
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<=n-1;j++)
                if((presum[j+1]-presum[i])%k==0)
                    return true;
        
        return false;
    }
}