class Solution {
    
    private class Graph
    {
        private int V;
        private int E;
        private int[] v;
        //private boolean[] isSource;
        private List<Integer>[] adj;
        private boolean[] visited;
        private int[] prev;
        private int[] post;
        private int clock=1;
        
        
        public Graph(int V, int[][] edges)
        {
            this.V=V;
            this.E=edges.length;
            
            v=new int[V];
            //isSource=new boolean[V];
            visited=new boolean[V];
            adj=(ArrayList<Integer> []) new ArrayList[V];
            prev=new int[V];
            post=new int[V];
            
            for(int i=0;i<V;i++)
            {
                v[i]=i;
                //isSource[i]=true;
                adj[i]=new ArrayList<Integer>();
            }
            
            for(int i=0;i<E;i++)
            {
                adj[edges[i][1]].add(edges[i][0]);
                //isSource[edges[i][0]]=false;
            }
                
        }
        
        private void dfs()
        {
            for(int i=0;i<V;i++)
                if(!visited[i])
                    explore(i);
        }
        
        private void explore(int v)
        {
            visited[v]=true;
            prev[v]=clock;
            clock++;
            
            for(int w:adj[v])
            {
                if(!visited[w])
                {
                    explore(w);
                }
            }
            
            post[v]=clock;
            clock++;
        }
        
        // The directed graph has a cycle if and only if there exists backedge
        // The edge from a vertex with smaller post order number to a vertex with larger post order number
        public boolean hasCycle()
        {
            dfs();
            
            for(int i=0;i<V;i++)
            {
                for(int w:adj[i])
                {
                    if(post[w]>post[i])
                        return true;
                }
            }
            
            return false;
        }
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Graph G=new Graph(numCourses,prerequisites);
        
        return !G.hasCycle();
    }
}