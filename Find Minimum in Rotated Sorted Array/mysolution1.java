class Solution {
    public int findMin(int[] nums) {
        
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        if(n==1)
            return nums[0];
        
        int i=0,j=n-1;
        
        while(true)
        {
            if(nums[(i+1)%n]<nums[i])
                return nums[(i+1)%n];
            
            if(nums[(j+1)%n]<nums[j])
                return nums[(j+1)%n];
            
            i=(i+1)%n;
            j=(j+1)%n;
        }
        
        //return nums[(i+1)%nums.length];
        
    }
}