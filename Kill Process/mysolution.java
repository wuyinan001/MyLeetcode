class Solution {
    
    Map<Integer,List<Integer>> adj=new HashMap();
    List<Integer> ans=new ArrayList();
    
    private void dfs(int u)
    {
        ans.add(u);
        
        if(adj.containsKey(u))
        {
            for(int v:adj.get(u))
            {
                dfs(v);
            }
        }
        
    }
    
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        int n=pid.size();
        
        for(int i=0;i<n;i++)
        {
            if(!adj.containsKey(ppid.get(i)))
                adj.put(ppid.get(i),new ArrayList());
            
            adj.get(ppid.get(i)).add(pid.get(i));
        }
        
        dfs(kill);
        
        return ans;
        
    }
}