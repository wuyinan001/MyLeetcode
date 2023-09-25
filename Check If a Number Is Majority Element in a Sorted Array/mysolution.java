class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        
        int n=nums.length;
        int mid=0;
        int count=0;
        
        if(n%2!=0)
        {
            mid=n/2;
            
            while(mid<n&&target==nums[mid])
            {
                count++;
                mid++;
            }
            
            mid=n/2-1;
            
            while(mid>=0&&target==nums[mid])
            {
                count++;
                mid--;
            }
            
            return count>n/2;
        }
        else
        {
            mid=n/2-1;
            
            while(mid>=0&&target==nums[mid])
            {
                count++;
                mid--;
            }
            
            mid=n/2;
            
            while(mid<n&&target==nums[mid])
            {
                count++;
                mid++;
            }
            
            return count>n/2;
        }
    }
}