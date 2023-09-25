class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        int[] L=new int[n];
        
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]>=n-1-i)
                L[i]=1;
            else
            {
                int min=L[i+1]+1;
                for(int j=2;j<=nums[i];j++)
                {
                    if(min>L[i+j]+1)
                        min=L[i+j]+1;
                }
                
                L[i]=min;
            }
            
            //System.out.println("L["+i+"]:"+L[i]);
        }
        
        return L[0];
    }
}