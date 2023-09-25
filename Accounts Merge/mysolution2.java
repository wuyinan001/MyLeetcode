class Solution {
    
    private class Graph
    {
        int V;
        Map<String,List<String>> adj;
        Map<String,String> name;
        Map<String,Boolean> visited;
        Map<Integer,List<String>> cmp;
        int clock=0;
        
        public Graph(List<List<String>> accounts)
        {
            adj=new HashMap();
            name=new HashMap();
            visited=new HashMap();
            cmp=new HashMap();
            
            for(List<String> account:accounts)
            {
                String n=account.get(0);
                
                for(int i=1;i<account.size();i++)
                {
                    String email=account.get(i);
                    if(!adj.containsKey(email))
                        adj.put(email,new ArrayList());
                    
                    if(!visited.containsKey(email))
                        visited.put(email,false);
                    
                    if(!name.containsKey(email))
                        name.put(email,n);
                }
            }
            
            for(List<String> account:accounts)
            {
                String first=account.get(1);
                
                for(int i=2;i<account.size();i++)
                {
                    String s=account.get(i);
                    if(!adj.get(first).contains(s))
                        adj.get(first).add(s);
                    
                    if(!adj.get(s).contains(first))
                        adj.get(s).add(first);
                }
            }
            
            V=adj.size();
        }
        
        private void dfs(String u)
        {
            cmp.get(clock).add(u);
            visited.put(u,true);
            
            for(String v:adj.get(u))
            {
                if(!visited.get(v))
                    dfs(v);
            }
        }
        
        public void dfs()
        {
            for(String key:adj.keySet())
            {
                if(!visited.get(key))
                {
                    clock++;
                    cmp.put(clock,new ArrayList());
                    dfs(key);
                }
            }
        }
        
        
        public List<List<String>> getMerge()
        {
            
            List<List<String>> ans=new ArrayList();
            
            for(Integer i:cmp.keySet())
            {
                List<String> list=new ArrayList();
                List<String> emails=cmp.get(i);
                
                Collections.sort(emails);
                
                list.add(name.get(emails.get(0)));
                
                for(String s:emails)
                    list.add(s);
                
                ans.add(list);
            }
            
            return ans;
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Graph g=new Graph(accounts);
        g.dfs();
        
        return g.getMerge();
    }
}