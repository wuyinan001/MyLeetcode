class Solution {
    public int search(int[] nums, int target) {
        
        int n=nums.length;
        
        if(n==0)
            return -1;
        
        int lo=0,hi=n-1;
        int mid=lo+(hi-lo)/2;
        
        if(nums[0]<nums[mid]&&nums[mid]<nums[hi])
            return search(nums,target,lo,hi);
        
        //Find the index of min num
        int min=lo+(hi-lo)/2;
        while(lo<min)
        {
            if(nums[lo]<nums[min]&&nums[min]<nums[hi])
            {
                min=lo;
                break;
            }
            else if(nums[lo]<nums[min])
            {
                lo=min;
                min=lo+(hi-lo)/2;
            }
            else
            {
                hi=min;
                min=lo+(hi-lo)/2;
            }
        }
        
        min=min+1;
        
        //System.out.println("min index: "+min);
        
        if(search(nums,target,0,min-1)==-1&&search(nums,target,min,n-1)==-1)
            return -1;
        else if(search(nums,target,0,min-1)!=-1)
            return search(nums,target,0,min-1);
        else
            return search(nums,target,min,n-1);
            
        
    }
    
    private int search(int[] nums, int target, int lo, int hi)
    {
        if(lo>hi)
            return -1;
        
        int mid=lo+(hi-lo)/2;
        
        if(target==nums[mid])
            return mid;
        
        if(target<nums[mid])
            return search(nums,target,lo,mid-1);    
        
        return search(nums,target,mid+1,hi);
    }
}