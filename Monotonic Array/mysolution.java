class Solution {
    public boolean isMonotonic(int[] nums) {
        
        int status=0;
        
        int n=nums.length;
        
        if(n==1)
            return true;
        
        for(int i=1;i<n;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                if(nums[i]>nums[i-1])
                {
                    if(status==-1)
                        return false;
                    else
                        status=1;
                }
                else
                {
                    if(status==1)
                        return false;
                    else
                        status=-1;
                }
                
            }
        }
        
        return true;
        
    }
}