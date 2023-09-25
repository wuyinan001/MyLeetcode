class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        
        int lo=0,hi=n-1;
        int mid;
        
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
            
            if(target==nums[mid])
                return mid;
            
            if(target<nums[mid])
                hi=mid-1;
            else
                lo=mid+1;
        }
        
        return lo;
    }
}