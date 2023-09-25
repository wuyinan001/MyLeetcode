class Solution {
    
    private class UnionFind
    {
        private int count;
        private int[] parent;
        private int[] rank;
        
        public UnionFind(int m, int n)
        {
            count=0;
            
            parent=new int[n*m];
            rank=new int[n*m];
            
            // If position i is not visited, parent[i] is -1.
            for(int i=0;i<parent.length;i++)
                parent[i]=-1;
            
        }
        
        public void add(int x)
        {
            if(parent[x]!=-1)
                return;
            parent[x]=x;
            count++;
        }
        
        public int find(int x)
        {
            while(parent[x]!=x)
                x=parent[x];
            
            parent[x]=x;
            
            return x;
        }
        
        public void union(int x, int y)
        {
            int rx=find(x);
            int ry=find(y);
            
            if(rx==ry)
                return;
            
            if(rank[rx]>rank[ry])
                parent[ry]=rx;
            else
            {
                parent[rx]=ry;
                if(rank[rx]==rank[ry])
                    rank[ry]++;
            }
            
            count--;
        }
        
        public int size()
        {
            return count;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        
        List<Integer> ans=new ArrayList<>();
        UnionFind uf=new UnionFind(m,n);
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<positions.length;i++)
        {
            int x=n*positions[i][0]+positions[i][1];
            
            uf.add(x);
            
            for(int k=0;k<4;k++)
            {
                int xx=positions[i][0]+dir[k][0],yy=positions[i][1]+dir[k][1];
                if(xx>=0&&xx<m&&yy>=0&&yy<n&&uf.parent[n*xx+yy]!=-1)
                    uf.union(x,n*xx+yy);
            }
            
            ans.add(uf.size());
        }
        
        return ans;
        
    }
}