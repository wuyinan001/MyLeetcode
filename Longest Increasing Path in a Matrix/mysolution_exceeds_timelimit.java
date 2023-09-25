class Solution {
    
    private class Graph
    {
        private int V;
        private int E=0;
        private boolean[] visited;
        private List<Integer>[] adj;
        private int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        // Map each vertex to its postOrder number
        private Map<Integer,Integer> map;
        private int clock=1;
        // Topological list
        private List<Map.Entry<Integer,Integer>> list;
        
        
        public Graph(int[][] M)
        {
            int n=M.length, m=M[0].length;
            
            V=n*m;
            
            visited=new boolean[V];
            adj=new ArrayList[V];
            map=new HashMap<>();
            
            for(int v=0;v<V;v++)
                adj[v]=new ArrayList<>();
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    for(int k=0;k<4;k++)
                    {
                        int x=i+dir[k][0], y=j+dir[k][1];
                        if(x>=0&&x<n&&y>=0&&y<m&&M[i][j]<M[x][y])
                        {
                            adj[i*m+j].add(x*m+y);
                            E++;
                        }
                    }
                }
            }
        }
        
        
        public void dfs()
        {
            for(int v=0;v<V;v++)
            {
                if(!visited[v])
                    explore(v);
            }
            
            list=new ArrayList<>(map.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
                
                public int compare(Map.Entry<Integer,Integer> m1, Map.Entry<Integer,Integer> m2)
                {
                    return m2.getValue().compareTo(m1.getValue());
                }
            });
        }
        
        public void explore(int z)
        {
            visited[z]=true;
            clock++;
            
            for(int v:adj[z])
            {
                if(!visited[v])
                {
                    explore(v);
                }
            }
            
            map.put(z,clock);
            clock++;
        }
        
        // Print postOrder number of each vertex
        public void print()
        {
            for(int v=0;v<V;v++)
            {
                System.out.println(v+": "+map.get(v));
                
            }
        }
        
        // Find max distance from s
        public int findMaxDist(int s)
        {
            int ans=0;
            
            int[] dist=new int[V];
            
            for(int v=0;v<V;v++)
                dist[v]=Integer.MIN_VALUE;
            
            dist[s]=0;
            
            for(Map.Entry<Integer,Integer> entry:list)
            {
                int u=entry.getKey();
                
                for(int v:adj[u])
                {
                    if(dist[v]<dist[u]+1)
                    {
                        dist[v]=dist[u]+1;
                        ans=Math.max(ans,dist[v]);
                    }
                }
            }
            
            return ans;
        }
        
        public int findMaxPath()
        {
            int ans=1;
            
            for(int v=0;v<V;v++)
                ans=Math.max(ans,findMaxDist(v)+1);
            
            return ans;
        }
            
        
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix.length==0)
            return 0;
        
        Graph g=new Graph(matrix);
        
        g.dfs();
        //g.print();
        
        return g.findMaxPath();
    }
}