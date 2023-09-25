class Solution {
    
    private class Graph
    {
        int V;
        List<Integer>[] adj;
        boolean[] visited;
        Map<Integer,Integer> postOrder;
        int clock=0;
        int[][] edges;
        
        public Graph(int n, int[][] edges)
        {
            V=n;
            adj=new List[V];
            this.edges=edges;
            
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList();
            
            for(int[] edge:edges)
            {
                adj[edge[1]].add(edge[0]);
            }
            
            visited=new boolean[V];
            postOrder=new HashMap();
        }
        
        private void dfs(int u)
        {
            visited[u]=true;
            clock++;
            
            for(int v:adj[u])
            {
                if(!visited[v])
                    dfs(v);
            }
            
            clock++;
            postOrder.put(u,clock);
        }
        
        public void dfs()
        {
            for(int i=0;i<V;i++)
                if(!visited[i])
                    dfs(i);
        }
        
        public void print()
        {
            for(int i=0;i<V;i++)
                System.out.println("Node:"+i+" PostOrder:"+postOrder.get(i));
        }
        
        public int[] getOrder()
        {
            for(int[] edge:this.edges)
            {
                if(postOrder.get(edge[1])<postOrder.get(edge[0]))
                    return new int[0];
            }
            
            int[] ans=new int[V];
            
            PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
                
                public int compare(Integer a1, Integer a2)
                {
                    return postOrder.get(a2)-postOrder.get(a1);
                }
                
            });
            
            for(int i=0;i<V;i++)
                pq.add(i);
            
            int k=0;
            while(!pq.isEmpty())
                ans[k++]=pq.poll();
            
            return ans;
        }
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Graph g=new Graph(numCourses,prerequisites);
        
        g.dfs();
        
        //g.print();
        
        return g.getOrder();
    }
}