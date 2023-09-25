class Solution {
    public String longestPalindrome(String s) {
        
        int n=s.length();
        
        if(n==0)
            return "";
        
        boolean[][] L=new boolean[n][n];
        
        int max=1;
        int[] range=new int[]{0,0};
        
        for(int i=0;i<n;i++)
        {
            L[i][i]=true;
        }
        
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                L[i][i+1]=true;
                if(max<2)
                {
                    max=2;
                    range[0]=i;
                    range[1]=i+1;
                }
            }
        }
        
        for(int g=2;g<=n-1;g++)
        {
            for(int i=0;i<n-g;i++)
            {
                int j=i+g;
                
                if(L[i+1][j-1]&&(s.charAt(i)==s.charAt(j)))
                {
                    L[i][j]=true;
                    if(max<j-i+1)
                    {
                        max=j-i+1;
                        range[0]=i;
                        range[1]=j;
                    }
                }
            }
        }
        
        return s.substring(range[0],range[1]+1);
    }
}