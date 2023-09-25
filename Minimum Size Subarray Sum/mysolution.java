class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n=nums.length;
        
        int start=0, end=0, ans=Integer.MAX_VALUE;
        
        int sum=0;
        
        while(end<n)
        {
            sum+=nums[end];
            
            if(sum>=target)
            {
                while(sum>=target)
                {
                    sum-=nums[start++];
                }
                
                ans=Math.min(ans,end-start+2);
            }
            
            end++;
        }
        
        return ans==Integer.MAX_VALUE ? 0 : ans;
        
    }
}