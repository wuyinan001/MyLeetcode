class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        int n=s.length();
        
        boolean[] dp1=new boolean[n+1];
        dp1[0]=true;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp1[j]&&wordDict.contains(s.substring(j,i)))
                {
                    dp1[i]=true;
                    break;
                }
            }
        }
        
        if(!dp1[n])
            return new ArrayList<String>();
        
        List<String>[] dp=new ArrayList[n+1];
        List<String> initial=new ArrayList<>();
        
        initial.add("");
        dp[0]=initial;
        
        for(int i=1;i<=n;i++)
        {
            List<String> list=new ArrayList<>();
            
            for(int j=0;j<i;j++)
            {
                if(!dp[j].isEmpty()&&wordDict.contains(s.substring(j,i)))
                {
                    for(String k:dp[j])
                    {
                        list.add(k + (k.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            
            dp[i]=list;
        }
        
        return dp[n];
    }
    

}