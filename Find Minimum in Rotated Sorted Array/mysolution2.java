class Solution {
    public int findMin(int[] nums) {
        
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        if(n==1)
            return nums[0];
        
        int lo=0,hi=n-1;
        int mid=lo+(hi-lo)/2;
        
        while(mid>lo)
        {
            if(nums[lo]<nums[mid]&&nums[mid]<nums[hi])
                return nums[lo];
            
            if(nums[lo]<nums[mid])
            {
                lo=mid;
                mid=lo+(hi-lo)/2;
            }
            else
            {
                hi=mid;
                mid=lo+(hi-lo)/2;
            }
        }
        
        return Math.min(nums[mid],nums[hi]);
        
    }
}