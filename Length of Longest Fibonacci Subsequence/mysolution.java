class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int n=A.length;
        
        Map<Integer,Integer> index=new HashMap<Integer,Integer>();
        
        for(int i=0;i<n;i++)
            index.put(A[i],i);
        
        Map<Integer,Integer> longest=new HashMap<Integer,Integer>();
        
        int ans=0;
        
        for(int k=0;k<n;k++)
        {
            for(int j=1;j<k;j++)
            {
                int i=index.getOrDefault(A[k]-A[j],-1);
                
                if(i>=0&&i<j)
                {
                    int cand=longest.getOrDefault(i*n+j,2)+1;
                    longest.put(j*n+k,cand);
                    
                    ans=Math.max(ans,cand);
                }
            }
        }
        
        return ans;
    }
}