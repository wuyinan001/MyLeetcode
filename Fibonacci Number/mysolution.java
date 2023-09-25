class Solution {
    public int fib(int N) {
        if(N==0||N==1)
            return N;
        
        int[] F=new int[N+1];
        
        F[0]=0;
        F[1]=1;
        
        for(int i=2;i<=N;i++)
        {
            F[i]=F[i-1]+F[i-2];
        }
        
        return F[N];
    }
}