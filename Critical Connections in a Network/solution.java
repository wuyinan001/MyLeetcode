class Solution {
    
    private class Graph
    {
        private int V;
        private List<Integer>[] adj;
        private int[] low;
        private int[] arrival;
        private boolean[] visited;
        private int[] parent;
        private List<List<Integer>> ans;
        private int clock=0;
        
        public Graph(int V, List<List<Integer>> connections)
        {
            this.V=V;
            adj=new List[V];
            
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList<>();
            
            low=new int[V];
            arrival=new int[V];
            visited=new boolean[V];
            parent=new int[V];
            ans=new ArrayList();
            
            for(List<Integer> list:connections)
            {
                int u=list.get(0),v=list.get(1);
                
                adj[u].add(v);
                adj[v].add(u);
            }
        }
        
        public void dfs()
        {
            for(int i=0;i<V;i++)
            {
                if(!visited[i])
                    dfs(i);
            }
        }
        
        public void dfs(int u)
        {
            visited[u]=true;
            clock++;
            arrival[u]=clock;
            low[u]=clock;
            
            for(int v:adj[u])
            {
                if(!visited[v])
                {
                    parent[v]=u;
                    dfs(v);
                    low[u]=Math.min(low[v],low[u]);
                    
                    if(low[v]>arrival[u])
                    {
                        List<Integer> bridge=new ArrayList();
                        bridge.add(u);
                        bridge.add(v);
                        ans.add(bridge);
                    }
                }
                else
                {
                    if(v!=parent[u])
                        low[u]=Math.min(low[u],arrival[v]);
                }
            }
        }
        
        public List<List<Integer>> getBridges()
        {
            return ans;
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
            Graph g=new Graph(n,connections);
            
            g.dfs();
            
            return g.getBridges();
     
    }
    
    
}