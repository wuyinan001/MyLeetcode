class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        int i=0,j=1;
        
        // count: how many numbers with same value of nums[i] in the range of nums[0] to nums[i]
        int count=1;
        
        while(j<n)
        {
            if(count<2&&nums[i]==nums[j])
            {
                count++;
                nums[++i]=nums[j++];
            }
            else if(nums[i]==nums[j])
            {
                j++;
            }
            else
            {
                count=1;
                nums[++i]=nums[j++];
            }
        }
        
        return i+1;
    }
    
}