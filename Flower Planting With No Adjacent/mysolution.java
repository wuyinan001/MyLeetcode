class Solution {
    
    private class Graph
    {
        int V;
        List<Integer>[] adj;
        //boolean[] visited;
        int[] color;
        
        public Graph(int n, int[][] paths)
        {
            V=n+1;
            adj=new List[V];
            
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList();
            
            for(int[] path:paths)
            {
                adj[path[0]].add(path[1]);
                adj[path[1]].add(path[0]);
            }
            
            color=new int[V];
            
            for(int i=0;i<V;i++)
                color[i]=-1;
        }
        
        private void dfs(int u)
        {
            Set<Integer> set=new HashSet();
            set.add(1);
            set.add(2);
            set.add(3);
            set.add(4);
            
            for(int v:adj[u])
                if(color[v]!=-1)
                    set.remove(color[v]);
            
            for(int i:set)
            {
                color[u]=i;
                break;
            }
            
            for(int v:adj[u])
                if(color[v]==-1)
                    dfs(v);
        }
        
        public void dfs()
        {
            for(int i=1;i<V;i++)
                if(color[i]==-1)
                    dfs(i);
        }
        
        public int[] getNo()
        {
            int[] ans=new int[V-1];
            
            for(int i=1;i<V;i++)
                ans[i-1]=color[i];
            
            return ans;
        }
    }
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        Graph g=new Graph(n,paths);
        g.dfs();
        
        return g.getNo();
    }
}