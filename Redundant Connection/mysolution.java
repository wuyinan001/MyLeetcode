class Solution {
    
    private class Graph
    {
        int V=0;
        int E=0;
        List<Integer>[] adj;
        boolean[] visited;
        int[] arrival;
        int[] low;
        int[] parent;
        int clock=0;
        int[][] edges;
        List<String> ans;
        
        public Graph(int[][] edges)
        {
            for(int[] edge:edges)
            {
                V=Math.max(V,Math.max(edge[0],edge[1]));
            }
            
            V++;
            
            adj=new List[V];
            
            for(int i=1;i<V;i++)
            {
                adj[i]=new ArrayList<>();
            }
            
            for(int[] edge:edges)
            {
                E++;
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
            
            this.edges=edges;
            
            visited=new boolean[V];
            parent=new int[V];
            arrival=new int[V];
            low=new int[V];
            
            ans=new ArrayList();
            
        }
        
        public void dfs()
        {
            for(int i=1;i<V;i++)
                if(!visited[i])
                    dfs(i);
        }
        
        private void dfs(int u)
        {
            visited[u]=true;
            clock++;
            low[u]=clock;
            arrival[u]=clock;
            
            for(int v:adj[u])
            {
                if(!visited[v])
                {
                    parent[v]=u;
                    dfs(v);
                    low[u]=Math.min(low[u],low[v]);
                    
                    if(low[v]>arrival[u])
                    {
                        ans.add(u+"#"+v);
                        ans.add(v+"#"+u);
                    }
                        
                }
                else if(v!=parent[u])
                {
                    low[u]=Math.min(low[u],arrival[v]);
                }
                
            }
        }
        
        private void print(List<String> a)
        {
            for(String s:a)
                System.out.println(s);
        }
        
        public int[] redundant()
        {
            //print(ans);
            int[] result=new int[2];
            
            for(int i=E-1;i>=0;i--)
            {
                String s=edges[i][0]+"#"+edges[i][1];
                if(!ans.contains(s))
                    return new int[]{edges[i][0],edges[i][1]};
            }
            
            return result;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        
        Graph g=new Graph(edges);
        
        g.dfs();
        
        return g.redundant();
        
    }
}