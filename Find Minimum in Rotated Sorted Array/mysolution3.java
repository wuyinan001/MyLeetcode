class Solution {
    public int findMin(int[] nums) {
        
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        int lo=0,hi=n-1,mid;
        
        while(lo+1<hi)
        {
            if(nums[lo]<nums[hi])
                return nums[lo];
            
            mid=lo+(hi-lo)/2;
            
            if(nums[lo]<nums[mid])
                lo=mid;
            else
                hi=mid;
        }
        
        if(lo==hi)
            return nums[lo];
        else
            return Math.min(nums[lo],nums[hi]);
    }
}