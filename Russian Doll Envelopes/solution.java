class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int n=envelopes.length;
        
        if(n==0)
            return 0;
        
        Arrays.sort(envelopes,new Comparator<int[]>()
                    {
                        public int compare(int[] array1, int[] array2)
                        {
                            if(array1[0]==array2[0])
                                return array2[1]-array1[1];
                            
                            return array1[0]-array2[0];
                        }
                    });
        
        int[] num=new int[n];
        
        for(int i=0;i<n;i++)
            num[i]=envelopes[i][1];
        
        return longestLIS(num);
    }
    
    private int longestLIS(int[] num)
    {
        int n=num.length;
        
        if(n==0)
            return 0;
        
        int[] L=new int[n];
        
        L[0]=1;
        
        int max=L[0];
        
        for(int i=1;i<n;i++)
        {
            L[i]=1;
            
            for(int j=0;j<i;j++)
            {
                if(num[j]<num[i]&&L[i]<L[j]+1)
                    L[i]=L[j]+1;
            }
            
            if(max<L[i])
                max=L[i];
        }
        
        return max;
    }

}