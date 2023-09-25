class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        // L[i] holds length of continous increasing subsequence ending at i
        int[] L=new int[n];
        
        L[0]=1;
        
        int max=1;
        
        for(int i=1;i<n;i++)
        {
            if(nums[i]>nums[i-1])
                L[i]=L[i-1]+1;
            else
                L[i]=1;
            
            if(max<L[i])
                max=L[i];
        }
        
        return max;
    }
}