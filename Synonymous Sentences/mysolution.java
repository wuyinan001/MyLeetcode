class Solution {
    
    Map<Integer,List<String>> map=new HashMap();
    
    public class Graph
    {
        Set<String> vertices;
        Map<String,List<String>> adj;
        Map<String,Boolean> visited;
        int cmp=0;
        
        public Graph(List<List<String>> synonyms)
        {
            vertices=new HashSet();
            adj=new HashMap();
            visited=new HashMap();
            
            for(List<String> l:synonyms)
            {
                for(String s:l)
                {
                    if(!adj.containsKey(s))
                    {
                        vertices.add(s);
                        adj.put(s,new ArrayList());
                        visited.put(s,false);
                    }
                }
            }
            
            for(List<String> l:synonyms)
            {
                adj.get(l.get(0)).add(l.get(1));
                adj.get(l.get(1)).add(l.get(0));
            }
        }
        
        private void dfs(String u)
        {
            visited.put(u,true);
            
            if(!map.containsKey(cmp))
                map.put(cmp,new ArrayList());
            
            map.get(cmp).add(u);
            
            for(String v:adj.get(u))
            {
                if(!visited.get(v))
                    dfs(v);
            }
        }
        
        public void dfs()
        {
            for(String v:vertices)
                if(!visited.get(v))
                {
                    dfs(v);
                    cmp++;
                }
        }
    }
    
    private void backTrack(List<String> list, String s, String[] strs, int index)
    {
        if(index==strs.length)
        {
            list.add(s.substring(1));
            return;
        }
        
        String curr=strs[index];
        
        for(Map.Entry<Integer,List<String>> m:map.entrySet())
        {
            if(m.getValue().contains(curr))
            {
                for(String s2:m.getValue())
                    backTrack(list,s+" "+s2,strs,index+1);
                return;
            }
        }
        
        backTrack(list,s+" "+curr,strs,index+1);
    }
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        
        List<String> ans=new ArrayList();
        String[] strs=text.split(" ");
        
        Graph g=new Graph(synonyms);
        
        g.dfs();
        
        for(Map.Entry<Integer,List<String>> m:map.entrySet())
        {
            Collections.sort(m.getValue(),new Comparator<String>(){
                
                public int compare(String s1, String s2)
                {
                    return s1.compareTo(s2);
                }
            });
        }
        
        /* Verify the connected components
        for(Map.Entry<Integer,List<String>> m:map.entrySet())
        {
            System.out.print(m.getKey()+": ");
            for(String s:m.getValue())
            {
                System.out.print(s+" ");
            }
            System.out.println();
        }*/
        
        backTrack(ans,"",strs,0);
        
        return ans;
    }
}