class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        
        if(n==0)
            return 0;
        
        // count[i][j] records num of palindromic substrings from index i to j
        int[][] count=new int[n][n];
        // P[i][j] records whether the substring from index i to j is palindromic
        boolean[][] P=new boolean[n][n];
        
        // length 1 substring case
        for(int i=0;i<n;i++)
        {
            count[i][i]=1;
            P[i][i]=true;
        }
        
        // length 2 substring case
        for(int i=0;i<n-1;i++)
        {
            if(s.substring(i,i+1).equals(s.substring(i+1,i+2)))
            {
                P[i][i+1]=true;
                count[i][i+1]=count[i][i]+count[i+1][i+1]+1;
            }
            else
            {
                count[i][i+1]=count[i][i]+count[i+1][i+1];
            }
        }
        
        // length >=3 substring case
        for(int gap=2;gap<n;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                
                if(s.substring(i,i+1).equals(s.substring(j,j+1))&&P[i+1][j-1]==true)
                {
                    count[i][j]=count[i][j-1]+count[i+1][j]-count[i+1][j-1]+1;
                    P[i][j]=true;
                }
                else
                    count[i][j]=count[i][j-1]+count[i+1][j]-count[i+1][j-1];
            }
        }
        
        return count[0][n-1];
    }
    
}