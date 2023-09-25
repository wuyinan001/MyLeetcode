class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return n;
        
        int i=0,j;
        
        for(j=1;j<n;j++)
        {
            if(nums[j]!=nums[i])
            {
                i++;
                nums[i]=nums[j];
            }
        }
        
        return i+1;
    }
}