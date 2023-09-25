class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        
        if(n==0)
            return "";
        
        // P[i][j] shows whether the substring from i to j is palindromic;
        // 1 if yes, 0 if no;
        int[][] P=new int[n][n];
        int maxgap=0;
        int start_index=0;
        int end_index=0;
        
        for(int i=0;i<n;i++)
            P[i][i]=1;
        
        for(int i=0;i<n-1;i++)
            if(s.substring(i,i+1).equals(s.substring(i+1,i+2)))
            {
                P[i][i+1]=1;
                maxgap=1;
                start_index=i;
                end_index=i+1;
            } 
        
        for(int gap=2;gap<n;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                
                if(s.substring(i,i+1).equals(s.substring(j,j+1))&&P[i+1][j-1]==1)
                {
                    P[i][j]=1;
                    if(maxgap<gap)
                    {
                        maxgap=gap;
                        start_index=i;
                        end_index=j;
                    }
                }  
            }
        }
        
        return s.substring(start_index,end_index+1);
    }
}