class Solution {

    
    public int numRollsToTarget(int d, int f, int target) {
        
        int[][] L=new int[d+1][target+1];
        
        L[0][0]=1;
        
        for(int i=1;i<=d;i++)
        {
            for(int t=1;t<=target;t++)
            {
                for(int j=1;j<=Math.min(f,t);j++)
                {
                    L[i][t]=(L[i][t]+L[i-1][t-j])%((int)(1e9+7));
                }
            }
        }
        
        return L[d][target];
    }
}