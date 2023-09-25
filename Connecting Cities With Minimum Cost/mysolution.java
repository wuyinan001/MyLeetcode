class Solution {
    
    private class UF
    {
        int V;
        int[] pi;
        int[] rank;
        
        public UF(int n)
        {
            V=n+1;
            pi=new int[V];
            rank=new int[V];
            
            for(int i=1;i<V;i++)
                pi[i]=i;
        }
        
        public int find(int x)
        {
            int root=x;
            
            while(root!=pi[root])
                root=pi[root];
            
            pi[root]=root;
            return root;
        }
        
        public boolean isConnected(int x, int y)
        {
            return find(x)==find(y);
        }
        
        public void connect(int x, int y)
        {
            if(isConnected(x,y))
                return;
            
            int rx=find(x),ry=find(y);
            
            if(rank[rx]>rank[ry])
                pi[ry]=rx;
            else
            {
                pi[rx]=ry;
                if(rank[rx]==rank[ry])
                    rank[ry]++;
            }
        }
        
        public boolean allConnected()
        {
            for(int i=2;i<V;i++)
            {
                if(!isConnected(1,i))
                    return false;
            }
            
            return true;
        }
    }
    
    public int minimumCost(int N, int[][] connections) {
        
        int ans=0;
        
        UF uf=new UF(N);
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a1[2]-a2[2];
            }
        });
        
        for(int[] c:connections)
            pq.add(c);
        
        while(!pq.isEmpty())
        {
            int[] c=pq.poll();
            
            if(!uf.isConnected(c[0],c[1]))
            {
                ans+=c[2];
                uf.connect(c[0],c[1]);
            }
            
            if(uf.allConnected())
                break;
        }
        
        if(!uf.allConnected())
            return -1;
        else
            return ans;
    }
}