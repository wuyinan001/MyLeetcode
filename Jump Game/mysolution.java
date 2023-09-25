class Solution {
    public boolean canJump(int[] nums) {
        
        int n=nums.length;
        
        if(n==0)
            return false;
        
        boolean[] L=new boolean[n];

        L[n-1]=true;
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=1;j<=Math.min(nums[i],n-1-i);j++)
            {
                if(L[i+j])
                {
                    L[i]=true;
                    break;
                }
            }
        }
        
        return L[0];
    }
}