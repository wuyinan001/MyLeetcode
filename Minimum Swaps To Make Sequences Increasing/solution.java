class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        
        int n=nums1.length;
        
        // dp[i][0]: min cost to make nums1 increasing without swap at i
        // dp[i][1]: min cost to make nums1 increasing with swap at i
        int[][] dp=new int[n][2];
        
        for(int i=1;i<n;i++)
        {
            dp[i][0]=Integer.MAX_VALUE;
            dp[i][1]=Integer.MAX_VALUE;
        }
        
        dp[0][0]=0;
        dp[0][1]=1;
        
        for(int i=1;i<n;i++)
        {
            if(nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1])
            {
                // No swap
                dp[i][0]=dp[i-1][0];
                // Swap at i and i-1
                dp[i][1]=dp[i-1][1]+1;
            }
            
            if(nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1])
            {
                // Pick one the following options which get the smaller cost:
                
                // Option 1: If nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1] and no swap at i before, no swap
                // Option 2: swap at i-1 and no swap at i;
                dp[i][0]=Math.min(dp[i][0],dp[i-1][1]);
                // Option 1: If nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1] and swap at i before, no swap 
                // Option 2: swap at i and no swap at i-1;
                dp[i][1]=Math.min(dp[i][1],dp[i-1][0]+1);
            }
        }
        
        return Math.min(dp[n-1][0],dp[n-1][1]);
    }
}