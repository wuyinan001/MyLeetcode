class Solution {
    
    private int binarySearch(int[] nums, int lo, int hi)
    {
        if(lo>hi)
            return -1;
        
        if(lo==hi)
            return lo;
        
        int mid=lo+(hi-lo)/2;
        
        if(nums[mid]<nums[mid+1])
            return binarySearch(nums,mid+1,hi);
        else
            return binarySearch(nums,lo,mid);
    }
    
    public int findPeakElement(int[] nums) {
        
        return binarySearch(nums,0,nums.length-1);
    }
}