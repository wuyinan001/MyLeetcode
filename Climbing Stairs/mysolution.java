class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        
        int[] climbways=new int[n];
        
        climbways[0]=1;
        climbways[1]=2;
        
        for(int i=2;i<n;i++)
        {
            climbways[i]=(climbways[i-1])+(climbways[i-2]+1)-1;
        }
        
        return climbways[n-1];
    }
}