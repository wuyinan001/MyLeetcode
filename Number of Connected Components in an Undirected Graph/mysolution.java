class Solution {
    
    private class Graph
    {
        private int V;
        private List<Integer>[] adj;
        private boolean[] visited;
        private int cc=1;
        
        public Graph(int n, int[][] edges)
        {
            this.V=n;
            
            adj=new ArrayList[V];
            visited=new boolean[V];
            
            for(int i=0;i<V;i++)
            {
                adj[i]=new ArrayList<>();
            }
            
            for(int[] edge:edges)
            {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
        }
        
        private void explore(int v)
        {
            
            visited[v]=true;
            
            for(int w:adj[v])
            {
                if(!visited[w])
                    explore(w);
            }
        }
        
        private void dfs()
        {
            for(int i=0;i<V;i++)
            {
                if(!visited[i])
                {
                    explore(i);
                    cc++;
                }
            }
        }
        
        public int ccnum()
        {
            dfs();
            return cc-1;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        
        Graph g=new Graph(n,edges);
        return g.ccnum();
    }
}