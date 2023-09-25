class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        
        Arrays.sort(nums);
        
        int lo=0,hi=n-1;
        
        while(nums[lo]!=nums[hi])
        {
            int mid=lo+(hi-lo)/2;
            
            // Duplicate locates at second half
            if(nums[mid]>=mid+1)
            {
                lo=mid+1;
            }
            // Duplicate locates at first half
            else
            {
                hi=mid;
            }
        }
        
        return nums[lo];
    }
}