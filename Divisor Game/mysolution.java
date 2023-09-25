class Solution {
    public boolean divisorGame(int N) {
        
        boolean[] result=new boolean[N+1];
        
        result[1]=false;
        
        for(int i=2;i<=N;i++)
        {
            if(!result[i-1])
                result[i]=true;
            else
            {
                for(int j=2;j<=i/2;j++)
                {
                    if(i%j==0&&!result[i-j])
                        result[i]=true;
                }
            }
            
        }
        
        return result[N];
    }
}