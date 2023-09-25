class Solution {
    public int countSubstrings(String s) {
        
        if(s.equals(""))
            return 1;
        
        int count=0;
        
        int n=s.length();
        
        boolean[][] P=new boolean[n][n];
        
        for(int i=0;i<n;i++)
            P[i][i]=true;
        
        count=count+n;
        
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                P[i][i+1]=true;
                count++;
            }
        }
        
        for(int gap=2;gap<=n-1;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                if(s.charAt(i)==s.charAt(j)&&P[i+1][j-1])
                {
                    count++;
                    P[i][j]=true;
                }
            }
        }
        
        return count;
    }
}