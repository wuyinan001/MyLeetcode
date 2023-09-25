class Solution {
    
    private void exchange(char[] nums, int i, int j)
    {
        char t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    private void sort(char[] nums, int lo, int hi)
    {
        for(int i=lo+1;i<=hi;i++)
        {
            for(int j=i;j>lo&&nums[j]<nums[j-1];j--)
            {
                exchange(nums,j,j-1);
            }
        }
    }
    
    private void nextPermutation(char[] nums, int n)
    {
        int i=n-1;
        while(i>0)
        {
            if(nums[i]>nums[i-1])
                break;
            i--;
        }
        
        if(i==0)
        {
            sort(nums,0,n-1);
            return;
        }
        
        i--;
        
        int j=n-1;
        
        while(j>i)
        {
            if(nums[j]>nums[i])
                break;
            j--;
        }
        
        //System.out.println("i"+i+"j"+j);
            
        exchange(nums,i,j);
        sort(nums,i+1,n-1);
    }
    
    public String getPermutation(int n, int k) {
        
        char[] nums=new char[n];
        
        for(int i=0;i<n;i++)
            nums[i]=(char)(i+'1');
        
        if(k==1)
            return new String(nums);
        
        for(int i=2;i<=k;i++)
        {
            nextPermutation(nums,n);
            //System.out.println(new String(nums));
        }
        
        return new String(nums);
    }
}