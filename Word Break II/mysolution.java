class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> ans=new ArrayList();
        
        int n=s.length();
        
        boolean[] P=new boolean[n+1];
        P[0]=true;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(P[j]&&wordDict.contains(s.substring(j,i)))
                {
                    P[i]=true;
                    break;
                }
            }
        }
        
        if(!P[n])
            return ans;
        
        for(int j=0;j<n;j++)
        {
            if(P[j]&&wordDict.contains(s.substring(j,n)))
            {
                List<String> list=wordBreak(s.substring(0,j),wordDict);
                
                if(list.isEmpty())
                    ans.add(s.substring(j,n));
                else
                {
                    for(String str:list)
                    {
                        ans.add(str+" "+s.substring(j,n));
                    }
                } 
            }
        }
        
        return ans;
    }
}