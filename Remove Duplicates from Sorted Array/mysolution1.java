class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        
        if(n==0||n==1)
            return n;
        
        int i=1;
        
        while(nums[i]>=nums[0])
        {
            if(nums[i]==nums[i-1])
            {
                for(int j=i+1;j<n;j++)
                {
                    nums[j-1]=nums[j];
                }
                nums[n-1]=nums[0]-1;
            }
            else
            {
                i++;
                if(i==n)
                    return i;
            }
                
        }
        
        return i;
    }
}