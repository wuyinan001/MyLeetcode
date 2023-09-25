class Solution {
    
    private class Graph
    {
        private int V=0;
        private boolean[] visited;
        private int[] color;
        private List<Integer>[] edges;
        private boolean bipartite=true;
        
        public Graph(int[][] graph)
        {
            V=graph.length;
            
            visited=new boolean[V];
            color=new int[V];
            edges=new List[V];
            
            for(int i=0;i<V;i++)
                edges[i]=new ArrayList<>();
            
            for(int i=0;i<V;i++)
            {
                for(int j:graph[i])
                {
                    edges[i].add(j);
                }
   
            }
        }
        
        private void dfs()
        {
            for(int i=0;i<V;i++)
            {
                if(!visited[i])
                {
                    color[i]=1;
                    explore(i);
                }  
            }
        }
        
        private void explore(int v)
        {
            visited[v]=true;
            
            for(int w:edges[v])
            {
                if(!visited[w])
                {
                    if(color[v]==1)
                        color[w]=2;
                    else
                        color[w]=1;
                    
                    explore(w);
                }
                else if(color[w]==color[v])
                    bipartite=false;
            }
        }
        
        public boolean isBipartite()
        {
            return bipartite;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        
        Graph g=new Graph(graph);
        
        g.dfs();
        
        return g.isBipartite();
    }
}