class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        
        if(n==0||n==1)
            return;
        
        int i=0;
        
        for(int j=1;j<n;j++)
        {
            if(nums[i]!=0)
                i++;
            else if(nums[i]==0&&nums[j]!=0)
                exchange(nums,i++,j);
        }
    }
    
    private void exchange(int[] a, int i, int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}