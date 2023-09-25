class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int lo=0,hi=nums.length-1;
        int mid;
        
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
            
            if(target<nums[mid])
            {
                hi=mid-1;
            }
            else if(target>nums[mid])
            {
                lo=mid+1;
            }
            else
            {
                int start=mid, end=mid;
                
                while(start>=0&&nums[start]==target)
                    start--;
                
                while(end<=nums.length-1&&nums[end]==target)
                    end++;
                
                return new int[]{start+1,end-1};
            }
        }
        
        return new int[]{-1,-1};
    }
}