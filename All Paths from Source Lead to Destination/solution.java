class Solution {
    
    private class Graph
    {
        int V;
        boolean[] visited;
        List<Integer>[] adj;
        int[] postOrder;
        int clock=0;
        int s,d;
        
        public Graph(int n, int[][] edges,int source, int destination)
        {
            V=n;
            visited=new boolean[V];
            postOrder=new int[V];
            adj=new List[V];
            
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList();
        
            for(int[] edge:edges)
                adj[edge[0]].add(edge[1]);
            
            s=source;
            d=destination;
        }
        
        public void dfs(int u)
        {
            visited[u]=true;
            clock++;
            
            for(int v:adj[u])
            {
                if(!visited[v])
                    dfs(v);
            }
            
            clock++;
            postOrder[u]=clock;
        }
        
        
        /* After running dfs from source node, check all the nodes that are visited(All the paths from source node). If there are some other destinations that are different from given destination, return false. If there is a cycle, also return false because having cycle means there are infinite number of paths. If there is an edge from lower postOrder node to higher postOrder node or from the same node, then there is a cycle.
        */
        public boolean noOtherDest()
        {
            for(int i=0;i<V;i++)
            {
                if(visited[i])
                {
                    if(!adj[i].isEmpty())
                    {
                        for(int j:adj[i])
                            if(postOrder[i]<=postOrder[j])
                                return false;
                    }
                    else if(i!=d)
                        return  false;
                }
            }
                
            return true;
        }
        
    }
    
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        Graph g=new Graph(n,edges,source,destination);
        g.dfs(source);
        
        return g.noOtherDest();
        
    }
}