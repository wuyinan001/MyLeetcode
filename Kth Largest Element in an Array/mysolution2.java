class Solution {
    private int[] aux;
    
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        
        sort(nums);
        //print(nums);
        
        return nums[n-k];
    }
    
    private boolean less(int a, int b)
    {
        return a<b;
    }
    
    private void exchange(int[] a, int i, int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    
    private void sort(int[] a)
    {
        aux=new int[a.length];
        sort(a,0,a.length-1);
    }
    
    private void sort(int[] a, int lo, int hi)
    {
        //System.out.println("lo:"+lo+" hi:"+hi);
        
        if(lo>=hi)
            return;
        
        int mid=lo+(hi-lo)/2;
        
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        
        //System.out.println("Merging: lo "+lo+" mid "+mid+" hi "+hi);
        merge(a,lo,hi,mid);
    }
    
    private void merge(int[] a, int lo, int hi, int mid)
    {
        
        for(int k=lo;k<=hi;k++)
        {
            aux[k]=a[k];
        }
        
        //System.out.println("aux");
        //print(aux);
        
        int i=lo,j=mid+1;
        
        for(int k=lo;k<=hi;k++)
        {
            if(i>mid)
                a[k]=aux[j++];
            else if(j>hi)
                a[k]=aux[i++];
            else if(less(aux[i],aux[j]))
                a[k]=aux[i++];
            else
                a[k]=aux[j++];
        }
        
        //System.out.println("a");
        //print(a);
    }
    
    private void print(int[] a)
    {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    
}