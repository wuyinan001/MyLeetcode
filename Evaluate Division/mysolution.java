class Solution {
    
    private class UF
    {
        Map<String,Integer> map;
        int V;
        int[] pi;
        int[] rank;
        // ratio[i]: the ratio of i/root(i);
        double[] ratio;
        List<List<String>> equations;
        double[] values;
        
        public UF(List<List<String>> equations, double[] values)
        {
            int n=values.length;
            V=0;
            this.equations=equations;
            this.values=values;
            map=new HashMap();
            
            for(int i=0;i<n;i++)
            {
                String s1=equations.get(i).get(0);
                String s2=equations.get(i).get(1);
                
                if(!map.containsKey(s1))
                    map.put(s1,V++);
                
                if(!map.containsKey(s2))
                    map.put(s2,V++);
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
            
            while(pi[rx]!=rx)
                rx=pi[rx];
            
            pi[x]=rx;
            return rx;
        }
        
        public boolean isConnected(int x, int y)
        {
            return find(x)==find(y);
        }
        
        // value: ratio x/y
        public void connect(int x, int y, double value)
        {
            if(isConnected(x,y))
                return;
            
            int rx=find(x), ry=find(y);
            
            if(rank[rx]>rank[ry])
            {
                pi[ry]=rx;
                ratio[ry]=1/value*ratio[x]/ratio[y];
                
                // For all the nodes t rooted at ry, change their root to rx and update their ratios to t/rx
                for(String s:map.keySet())
                {
                    int temp=map.get(s);
                    if(pi[temp]==ry)
                    {
                        pi[temp]=rx;
                        ratio[temp]=ratio[temp]*ratio[ry];
                    }
                }
            }
            else
            {
                pi[rx]=ry;
                ratio[rx]=value*ratio[y]/ratio[x];
                
                // For all the nodes t rooted at rx, change their root to ry and update their ratios to t/ry
                for(String s:map.keySet())
                {
                    int temp=map.get(s);
                    if(pi[temp]==rx)
                    {
                        pi[temp]=ry;
                        ratio[temp]=ratio[temp]*ratio[rx];
                    }
                }
                
                if(rank[rx]==rank[ry])
                    rank[ry]++;
            }
        }
        
        
        public void print()
        {
            for(String s:map.keySet())
            {
                System.out.println("key: "+s+" index: "+map.get(s)+" root: "+find(map.get(s))+" ratio: "+ratio[map.get(s)]);
            }
        }
        
        public void buildUF()
        {
            for(int i=0;i<values.length;i++)
            {
                //System.out.println("Connect "+equations.get(i).get(0)+" to "+equations.get(i).get(1));
                connect(map.get(equations.get(i).get(0)),map.get(equations.get(i).get(1)),values[i]);
                //print();
            }
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        UF uf=new UF(equations,values);
        
        uf.buildUF();
        
        //uf.print();
        
        int n=queries.size();
        
        double[] ans=new double[n];
        
        for(int i=0;i<n;i++)
        {
            String s1=queries.get(i).get(0);
            String s2=queries.get(i).get(1);
            
            if(uf.map.containsKey(s1)&&uf.map.containsKey(s2)&&uf.isConnected((uf.map.get(s1)),uf.map.get(s2)))
            {
                ans[i]=uf.ratio[uf.map.get(s1)]/uf.ratio[uf.map.get(s2)];
            }
            else
                ans[i]=-1.0;
            
        }
        
        return ans;
    }
}