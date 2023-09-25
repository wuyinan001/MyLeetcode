class Solution {
    public int findMaxLength(int[] nums) {
        
        int n=nums.length;
        
        for(int i=1;i<n;i++)
        {
            nums[i]+=nums[i-1];
        }
        
        for(int gap=n-1;gap>=1;gap--)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                if(i==0)
                {
                    if(nums[j]*2==gap+1)
                        return gap+1;
                }
                else
                {
                    if((nums[j]-nums[i-1])*2==gap+1)
                        return gap+1;
                }
            }
        }
        
        return 0;
    }
}