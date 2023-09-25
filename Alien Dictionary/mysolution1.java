class Solution {
    
    private class Graph
    {
        int V;
        Map<Character,Integer> map; 
        List<Integer>[] adj;
        boolean[] visited;
        int[] postOrder;
        int clock=0;
        
        public Graph(String[] words)
        {
            map=new HashMap();
            
            int count=0;
            for(String word:words)
                for(int i=0;i<word.length();i++)
                    if(!map.containsKey(word.charAt(i)))
                        map.put(word.charAt(i),count++);
            
            V=map.size();
            
            adj=new List[V];
            visited=new boolean[V];
            postOrder=new int[V];
            
            for(int i=0;i<V;i++)
                adj[i]=new ArrayList();
            
            for(int i=0;i<words.length-1;i++)
            {
                for(int j=0;j<Math.min(words[i].length(),words[i+1].length());j++)
                {
                    char c1=words[i].charAt(j), c2=words[i+1].charAt(j);
                    if(c1!=c2)
                    {
                        adj[map.get(c1)].add(map.get(c2));
                        break;
                    }
                }
            }
            
        }
        
        public void dfs()
        {
            for(int i=0;i<V;i++)
                if(!visited[i])
                    dfs(i);
        }
        
        private void dfs(int v)
        {
            clock++;
            visited[v]=true;
            
            for(int i:adj[v])
                if(!visited[i])
                    dfs(i);
            
            clock++;
            postOrder[v]=clock;
        }
        
        public void print()
        {
            for(Map.Entry<Character,Integer> m:map.entrySet())
                System.out.println(m.getKey()+" postOrder: "+postOrder[m.getValue()]);
        }
        
        public boolean hasCycle()
        {
            for(int i=0;i<V;i++)
                for(int j=0;j<adj[i].size();j++)
                    if(postOrder[i]<postOrder[adj[i].get(j)])
                        return true;

            return false;
        }
        
        public String alienOrder()
        {
            if(hasCycle())
                return "";
            
            PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>(new Comparator<Map.Entry<Character,Integer>>(){
                
                public int compare(Map.Entry<Character,Integer> m1, Map.Entry<Character,Integer> m2)
                {
                    return postOrder[m2.getValue()]-postOrder[m1.getValue()];
                }
                
            });
            
            for(Map.Entry<Character,Integer> m:map.entrySet())
                pq.add(m);
            
            StringBuilder sb=new StringBuilder();
            
            while(!pq.isEmpty())
                sb.append(pq.poll().getKey());
            
            return sb.toString();
        }
    }
    
    public String alienOrder(String[] words) {
        
        
        for(int i=0;i<words.length-1;i++)
        {
            if(words[i].length()>words[i+1].length()&&words[i+1].equals(words[i].substring(0,words[i+1].length())))
                return "";
        }
        
        Graph g=new Graph(words);
        
        g.dfs();
        
        //g.print();
        
        return g.alienOrder();
    }
}