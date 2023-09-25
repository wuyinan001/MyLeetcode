class Solution {
    
    private class Graph
    {
        int V;
        int E;
        List<Integer>[] adj;
        boolean[] visited;
        
        int cmp=0;
        
        public Graph(int n, int[][] edges)
        {
            V=n;
            E=edges.length;
            
            adj=new List[V];
            
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList();
            
            for(int[] edge:edges)
            {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
            
            visited=new boolean[V];
        }
        
        private void dfs(int u)
        {
            visited[u]=true;
            
            for(int v:adj[u])
                if(!visited[v])
                    dfs(v);
        }
        
        public void dfs()
        {
            for(int i=0;i<V;i++)
            {
                if(!visited[i])
                {
                    cmp++;
                    dfs(i);
                }
            }
        }
        
        public int change()
        {
            if(V>E+1)
                return -1;
            
            return cmp-1;
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
     
        Graph g=new Graph(n,connections);
        g.dfs();
        return g.change();
    }
}