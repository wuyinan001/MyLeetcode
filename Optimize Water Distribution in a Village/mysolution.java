class Solution {
    
    // Kruscal Algorithm: Consider a well as a node 0 and there is an edge between node 0 and every other node.
    // The cost of those edges are same as cost of opening well in those nodes(1-n)
    // Now we need to find the minimum cost of connecting all the nodes together(including well node)
    
    private class UF
    {
        int V;
        int[] pi;
        int[] rank;
        
        public UF(int n)
        {
            V=n+1;
            pi=new int[V];
            
            for(int i=0;i<V;i++)
                pi[i]=i;
            
            rank=new int[V];
        }
        
        public int find(int x)
        {
            int rx=x;
            
            while(pi[rx]!=rx)
                rx=pi[rx];
            
            pi[x]=rx;
            return rx;
        }
        
        public boolean isConnected(int x, int y)
        {
            return find(x)==find(y);
        }
        
        public void connect(int x, int y)
        {
            int rx=find(x), ry=find(y);
            
            if(rank[rx]>rank[ry])
                pi[ry]=rx;
            else
            {
                pi[rx]=ry;
                if(rank[rx]==rank[ry])
                    rank[ry]++;
            }
        }
        
    }
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] e1, int[] e2)
            {
                return e1[2]-e2[2];
            }
            
        });
        
        for(int i=0;i<n;i++)
            pq.add(new int[]{0,i+1,wells[i]});
        
        for(int[] p:pipes)
        {
            pq.add(p);
        }
        
        UF uf=new UF(n);
        
        int ans=0, edges=0;
        
        while(!pq.isEmpty())
        {
            // When all the nodes are connected, the number of edges should be n (because there are n+1 nodes including well node)
            if(edges==n)
                return ans;
            
            int[] p=pq.poll();
            
            if(!uf.isConnected(p[0],p[1]))
            {
                uf.connect(p[0],p[1]);
                ans+=p[2];
                edges++;
            }
        }
        
        return ans;
    }
}