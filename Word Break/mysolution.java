class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        
        if(n==0)
            return true;
        
        // wd[] contains whether the substring[0,i+1](not including i+1) can be broke into words or not
        boolean[] wd=new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            if(wd[i]==false&&wordDict.contains(s.substring(0,i+1)))
                wd[i]=true;
            
            if(i==n-1&&wd[i]==true)
                return true;
            
            if(wd[i]==true)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(wd[j]==false&&wordDict.contains(s.substring(i+1,j+1)))
                        wd[j]=true;
                    
                    if(j==n-1&&wd[j]==true)
                        return true;
                }
            }
        }
        
        return false;
    }
}