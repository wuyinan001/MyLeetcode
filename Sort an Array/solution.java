class Solution {

    private void exchange(int[] nums, int i, int j)
    {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    // find the right location of nums[lo] when nums[] is sorted, return that location and exchange nums[lo] with the value at that location;
    // Also make sure all the elements on the right side are equal or larger than nums[lo], the left side are equal or smaller than nums[lo];
    private int partition(int[] nums, int lo, int hi)
    {
        int i=lo, j=hi+1;
        int v=nums[lo];
        //System.out.println("lo "+lo+" hi "+hi);
        
        while(true)
        {
            while(nums[++i]<v)
            {
                if(i==hi)
                    break;
            }
            
            while(nums[--j]>v)
            {
                if(j==lo)
                    break;
            }
            
            if(i>=j)
                break;
            
            exchange(nums,i,j);
        }
        
        exchange(nums,lo,j);
        
        return j;
    }
    
    private void sort(int[] nums, int lo, int hi)
    {
        if(lo>=hi)
            return;
        
        int k=partition(nums,lo,hi);
        
        sort(nums,lo,k-1);
        sort(nums,k+1,hi);
    }

    
    public int[] sortArray(int[] nums) {
        
        sort(nums,0,nums.length-1);
        
        return nums;
    }
}