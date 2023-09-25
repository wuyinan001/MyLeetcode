class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        int n=nums.length,sum=0;
        
        for(int i:nums)
            sum=sum+i;
        
        int sum_save=sum;
        int max=0;
        
        for(int start=0;start<n;start++)
        {
            int end=n-1;
            sum=sum_save;
            
            while(start<=end)
            {
                if(sum==k&&max<end-start+1)
                    max=end-start+1;
                
                sum=sum-nums[end--];
            }
            
            sum_save=sum_save-nums[start];
        }
        
        return max;
    }
}