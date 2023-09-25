class Solution {
    public void sortColors(int[] nums) {
        sort(nums,0,nums.length-1);
    }
    
    private void sort(int[] nums, int lo, int hi)
    {
        if(lo>=hi)
            return;
        
        int i=lo+1,lt=lo,ht=hi;
        int v=nums[lt];
        
        while(i<=ht)
        {
            int cmp=nums[i]-v;
            
            if(cmp<0)
                exchange(nums,i++,lt++);
            else if(cmp>0)
                exchange(nums,i,ht--);
            else
                i++;
        }
        
        sort(nums,lo,lt-1);
        sort(nums,ht+1,hi);
    }
    
    
    private void exchange(int[] a, int i, int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}