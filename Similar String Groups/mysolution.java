class Solution {
    
    int cmp=0;
    Map<String,List<String>> adj=new HashMap();
    int V;
    Map<String,Boolean> visited=new HashMap();
    
    private boolean similar(String s1, String s2)
    {
        if(s1.equals(s2))
            return true;
        
        int count=0, n=s1.length();
        int[] diff=new int[2];
        
        for(int i=0;i<n;i++)
        {
            char c1=s1.charAt(i), c2=s2.charAt(i);
            
            if(c1!=c2)
            {
                if(count==2)
                    return false;
                
                diff[count++]=i;
            }
        }
        
        if(count<2)
            return false;
        
        return s1.charAt(diff[0])==s2.charAt(diff[1])&&s1.charAt(diff[1])==s2.charAt(diff[0]);
    }
    
    public int numSimilarGroups(String[] strs) {
        
        for(String s:strs)
        {
            adj.put(s,new ArrayList());
            visited.put(s,false);
        }
            
        for(int i=0;i<strs.length;i++)
        {
            for(int j=i+1;j<strs.length;j++)
            {
                if(similar(strs[i],strs[j]))
                {
                    adj.get(strs[i]).add(strs[j]);
                    adj.get(strs[j]).add(strs[i]);
                }
            }
        }
        
        V=strs.length;
        
        dfs();
        
        return cmp;
        
    }
    
    private void dfs(String u)
    {
        visited.put(u,true);
        
        for(String v:adj.get(u))
        {
            if(!visited.get(v))
            {
                dfs(v);
            }
        }
    }
    
    private void dfs()
    {
        for(String s:adj.keySet())
        {
            if(!visited.get(s))
            {
                cmp++;
                dfs(s);
            }
        }
    }
}