class Solution {
    
    private class Graph{
        
        private int V;
        private int E;
        private List<Integer>[] adj;
        private boolean[] visited;
        private int cc=1;
        
        public Graph(int n, int[][] edges)
        {
            V=n;
            E=edges.length;
            adj=new ArrayList[V];
            visited=new boolean[V];
            
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList<>();
            
            for(int[] e:edges)
            {
                adj[e[0]].add(e[1]);
                adj[e[1]].add(e[0]);
            }
        }
        
        private void explore(int z)
        {
            visited[z]=true;
            
            for(int v:adj[z])
            {
                if(visited[v]==false)
                    explore(v);
            }
        }
        
        private void dfs()
        {
            for(int i=0;i<V;i++)
            {
                if(visited[i]==false)
                {
                    explore(i);
                    cc++;
                }   
            }
        }
        
        public boolean isConnected()
        {
            dfs();
            //System.out.println("cc: "+cc);
            return cc==2;
        }
    }
    
    
    // If the graph connects all vertices and the number of edges==n-1, this graph is a valid tree
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length>=n)
            return false;
        
        Graph g=new Graph(n,edges);
        
        return g.isConnected();
        
    }
}