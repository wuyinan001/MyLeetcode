class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        
        for(int l=n/2;l>=1;l--)
        {
            sink(nums,l,n);
        }
        
        for(int i=1;i<=k-1;i++)
        {
            exchange(nums,1,n--);
            sink(nums,1,n);
        }
        
        return nums[0];
    }
    
    private boolean less(int a, int b)
    {
        return a<b;
    }
    
    private void exchange(int[] a, int i, int j)
    {
        int t=a[i-1];
        a[i-1]=a[j-1];
        a[j-1]=t;
    }
    
    private void sink(int[] a, int k, int n)
    {
        while(k<=n/2)
        {
            int i=k*2;
            
            if(i<n&&less(a[i-1],a[i+1-1]))
                i++;
            
            if(!less(a[k-1],a[i-1]))
                break;
            
            exchange(a,k,i);
            k=i;
        }
    }
}