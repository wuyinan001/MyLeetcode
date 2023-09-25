class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        
        if(n==0)
            return 0;
        
        // In case s is longer than 100.
        if(n>100)
        {
            s=s.substring(0,100);
            n=100;
        }
            
        
        int max=1;
        
        //L[i][j] contains the num of different chars in substring from index i to j
        int[][] L=new int[n][n];
        
        for(int i=0;i<n;i++)
            L[i][i]=1;
        
        for(int i=0;i<n-1;i++)
        {
            if(s.substring(i,i+1).equals(s.substring(i+1,i+2)))
                L[i][i+1]=1;
            else
                L[i][i+1]=2;
            
            if(max<L[i][i+1])
                max=L[i][i+1];
        }
             
        
        //int start=0;
        //int end=0;
        
        for(int gap=2;gap<n;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                
                if(s.substring(i,i+1).equals(s.substring(j,j+1)))
                    L[i][j]=L[i+1][j]+L[i][j-1]-L[i+1][j-1]-1;
                else
                    L[i][j]=L[i+1][j]+L[i][j-1]-L[i+1][j-1];
                
                if(max<L[i][j]&&L[i][j]==j-i+1)
                {
                    max=L[i][j];
                    //start=i;
                    //end=j;
                }
                           
            }
        }
        
        //System.out.println(start+" "+end);
        
        return max;
    }
}