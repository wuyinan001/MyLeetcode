class Solution {
    
    private class UF
    {
        int V;
        Map<String,Integer> map;
        int[] pi;
        int[] rank;
        // ratio[i]: the ratio of node i to its root node
        double[] ratio;
        
        public UF(List<List<String>> equations)
        {
            map=new HashMap();
            V=0;
            
            for(List<String> list:equations)
            {
                for(String s:list)
                {
                    if(!map.containsKey(s))
                        map.put(s,V++);
                }
            }
            
            pi=new int[V];
            
            for(int i=0;i<V;i++)
                pi[i]=i;
            
            rank=new int[V];
            ratio=new double[V];
            
            for(int i=0;i<V;i++)
                ratio[i]=1.0;
        }
        
        public int find(int x)
        {
            int rx=x;

            while(rx!=pi[rx])
            {
                rx=pi[rx];
            }
            
            pi[x]=rx;
            
            return rx;
        }
        
        public boolean isConnected(int x, int y)
        {
            return find(x)==find(y);
        }
        
        // r=v(x)/v(y);
        public void connect(int x, int y, double r)
        {
            if(isConnected(x,y))
                return;
            
            int rx=find(x), ry=find(y);
            
            if(rank[rx]>rank[ry])
            {
                ratio[ry]=1/r*ratio[x]/ratio[y];
                
                for(int v=0;v<V;v++)
                {
                    if(v!=ry&&find(v)==ry)
                        ratio[v]=ratio[v]*ratio[ry];
                }
                
                pi[ry]=rx;
            }
            else
            {
                ratio[rx]=r*ratio[y]/ratio[x];
                
                for(int v=0;v<V;v++)
                {
                    if(v!=rx&&find(v)==rx)
                        ratio[v]=ratio[v]*ratio[rx];
                }
                
                pi[rx]=ry;
                
                if(rank[rx]==rank[ry])
                    rank[ry]++;
            }
        }
    }
    
    private void print(UF uf)
    {
        System.out.println("Print UF");
        for(String s:uf.map.keySet())
        {
            System.out.println(s+" Node: "+uf.map.get(s)+" root: "+uf.find(uf.map.get(s))+" ratio:"+uf.ratio[uf.map.get(s)]);
        }
    }
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        UF uf=new UF(equations);
        
        int n=values.length;
        
        for(int i=0;i<n;i++)
        {
            String s1=equations.get(i).get(0), s2=equations.get(i).get(1);
            
            uf.connect(uf.map.get(s1),uf.map.get(s2),values[i]);
            
            //print(uf);
        }
        
        double[] ans=new double[queries.size()];
        
        for(int i=0;i<ans.length;i++)
        {
            String s1=queries.get(i).get(0), s2=queries.get(i).get(1);
            
            if(uf.map.containsKey(s1)&&uf.map.containsKey(s2)&&uf.isConnected(uf.map.get(s1),uf.map.get(s2)))
            {
                int v1=uf.map.get(s1), v2=uf.map.get(s2);
                ans[i]=uf.ratio[v1]/uf.ratio[v2];
            }
            else
                ans[i]=-1.0;
        }
        
        return ans;
    }
}