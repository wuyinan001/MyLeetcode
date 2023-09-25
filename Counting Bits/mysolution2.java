class Solution {
    
    private int numOfBits(int n)
    {
        int count=0;
        
        while(n!=0)
        {
            count=count+(n&1);
            n=n>>>1;
        }
        
        return count;
    }
    
    public int[] countBits(int num) {
        
        int[] ans=new int[num+1];
        
        for(int i=0;i<=num;i++)
        {
            ans[i]=numOfBits(i);
        }
        
        return ans;
    }
}