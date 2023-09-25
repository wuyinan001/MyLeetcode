class Solution {
    
    private class Graph
    {
        int V;
        List<Integer>[] adj;
        boolean[] visited;
        List<Boolean> list;
        
        public Graph(int n, int[][] edges, List<Boolean> hasApple)
        {
            V=n;
            adj=new List[V];
            
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList();
            
            for(int[] edge:edges)
            {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
            
            visited=new boolean[V];
            list=hasApple;
        }
        
        public int dfs(int u)
        {
            // Total number of edges to pick all apples in the subtree rooted at node u including u;
            int numOfSteps=0;
            
            visited[u]=true;
            
            for(int v:adj[u])
            {
                if(!visited[v])
                    numOfSteps+=dfs(v);
            }
            
            // If u is not the root and u has apples or u is on the path of other nodes with apples, then add two more edges that
            // go to and from node u
            if(u!=0&&(list.get(u)||numOfSteps>0))
                numOfSteps+=2;
            
            return numOfSteps;
        }
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        
        Graph g=new Graph(n,edges,hasApple);
        
        return g.dfs(0);
    }
}