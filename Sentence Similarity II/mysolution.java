class Solution {
    
    private class UF
    {
        int V;
        Map<String,Integer> map;
        int[] pi;
        int[] rank;
        
        public UF(List<List<String>> pairs)
        {
            map=new HashMap();
            V=0;
            
            for(List<String> pair:pairs)
            {
                if(!map.containsKey(pair.get(0)))
                    map.put(pair.get(0),V++);
                
                if(!map.containsKey(pair.get(1)))
                    map.put(pair.get(1),V++);
            }
            
            pi=new int[V];
            
            for(int i=0;i<V;i++)
                pi[i]=i;
            
            rank=new int[V];
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
        
        public boolean isConnected(String s1, String s2)
        {
            return find(map.get(s1))==find(map.get(s2));
        }

        
        public void connect(String s1, String s2)
        {
            if(!map.containsKey(s1)||!map.containsKey(s2))
                return;
            
            if(isConnected(s1,s2))
                return;
            
            int x=map.get(s1), y=map.get(s2);
            
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
        
        public boolean containsWord(String s)
        {
            return map.containsKey(s);
        }
        
    }
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        
        if(words1.length!=words2.length)
            return false;
        
        int n=words1.length;
        
        UF uf=new UF(pairs);
        
        for(List<String> pair:pairs)
            uf.connect(pair.get(0),pair.get(1));
        
        for(int i=0;i<n;i++)
        {
            if(words1[i].equals(words2[i]))
                continue;
                
            if(!uf.containsWord(words1[i])||!uf.containsWord(words2[i]))
                return false;
            
            if(!uf.isConnected(words1[i],words2[i]))
                return false;
        }
        
        return  true;
    }
}