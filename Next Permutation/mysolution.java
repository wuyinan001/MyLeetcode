class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        
        if(n==0||n==1)
            return;
        
        int i;
        for(i=n-1;i>0;i--)
        {
            if(nums[i-1]<nums[i])
                break;
        }
        
        //System.out.println("i: "+i);
       
        if(i==0)
        {
            sort(nums,0,n-1);
            return;
        }
        
        int j=i-1,min=i;
        
        for(int k=n-1;k>=i;k--)
        {
            if(nums[k]<nums[min]&&nums[k]>nums[j])
                min=k;
        }
        
        //System.out.println("min: "+min);
        //System.out.println("j: "+j);
        
        exchange(nums,j,min);
        sort(nums,i,n-1);
    }
    
    private void exchange(int[] a, int i, int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    
    // Sort from index i to index j
    private void sort(int[] nums, int i, int j)
    {
        for(int k=i;k<=j;k++)
        {
            int min=k;
            for(int l=k+1;l<=j;l++)
            {
                if(nums[min]>nums[l])
                    min=l;
            }
            
            //System.out.println("k: "+k+" min:"+min);
            exchange(nums,k,min);
        }
    }
    
}