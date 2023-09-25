class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        //maxSum array contains maximum sum of subarray that contains nums[i]
        int[] maxSum=new int[n];
        
        maxSum[0]=nums[0];
        int max=maxSum[0];
        
        for(int i=1;i<n;i++)
        {
            if(maxSum[i-1]<0)
                maxSum[i]=nums[i];
            else
                maxSum[i]=maxSum[i-1]+nums[i];
            
            if(max<maxSum[i])
                max=maxSum[i];
        }
        
        return max;
    }
}