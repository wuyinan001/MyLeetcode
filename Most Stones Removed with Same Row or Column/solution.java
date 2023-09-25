class Solution {
    
    private class UF
    {
        int V;
        int[] pi;
        int[] rank;
        
        public UF(int[][] stones)
        {
            V=stones.length;
            pi=new int[V];
            rank=new int[V];
            
            for(int i=0;i<V;i++)
                pi[i]=i;
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
            if(isConnected(x,y))
                return;
            
            int rx=find(x), ry=find(y);
            
            if(rank[rx]>rank[ry])
            {
                pi[ry]=rx;
            }
            else
            {
                pi[rx]=ry;
                if(rank[rx]==rank[ry])
                    rank[ry]++;
            }
        }
        
        public int numOfGroups()
        {
            Set<Integer> set=new HashSet();
            
            for(int i=0;i<V;i++)
            {
                //System.out.println("Node: "+i+" root: "+find(i));
                set.add(find(i));
            }
                
            
            return set.size();
        }
    }
    
    public int removeStones(int[][] stones) {
        
        UF uf=new UF(stones);
        int n=stones.length;
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
                    uf.connect(i,j);
        }
        
        return n-uf.numOfGroups();
    }
}