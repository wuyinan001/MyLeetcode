class Solution {
    
    private class Graph
    {
        private int V;
        private int E;
        private Map<Character,Integer> VS;
        private List<Character>[] adj;
        private boolean[] visited;
        private int clock=1;
        private Map<Character,Integer> postOrder;
        
        
        public Graph(List<char[]> edges)
        {
            postOrder=new HashMap<>();
            VS=new HashMap<>();
            
            V=0;
            
            // VS contains all the character vertices. Each vertice maps to an unique integer
            for(char[] edge:edges)
            {
                if(edge[0]==edge[1]&&!VS.containsKey(edge[0]))
                {
                    VS.put(edge[0],V++);
                    continue;
                }
                
                if(!VS.containsKey(edge[0]))
                    VS.put(edge[0],V++);
                
                if(!VS.containsKey(edge[1]))
                    VS.put(edge[1],V++);
            }
            
            V=VS.size();
            
            visited=new boolean[V];
            adj=new ArrayList[V];
            
            for(int i=0;i<V;i++)
            {
                adj[i]=new ArrayList<>();
            }
            
            // adj index
            for(char[] edge:edges)
            {
                if(edge[0]!=edge[1])
                    adj[VS.get(edge[0])].add(edge[1]);
            }
            
        }
        
        private void explore(char z)
        {
            visited[VS.get(z)]=true;
            clock++;
            
            for(char v:adj[VS.get(z)])
            {
                if(!visited[VS.get(v)])
                    explore(v);
            }
            
            postOrder.put(z,clock);
            clock++;
        }
        
        private void dfs()
        {
            for(char v:VS.keySet())
            {
                if(!visited[VS.get(v)])
                    explore(v);
            }
        }
        
        private void printPostOrder()
        {
            for(char z:postOrder.keySet())
                System.out.println("postOrder: "+z+"->"+postOrder.get(z));
        }
        
        
        private boolean hasCycle()
        {
            
            for(char z:VS.keySet())
            {
                for(char c:adj[VS.get(z)])
                    if(postOrder.get(z)<postOrder.get(c))
                        return true;
            }
            
            return false;
        }
        
        private String makeOrder()
        {
            dfs();
            
            //printPostOrder();
            
            if(hasCycle())
                return "";
            
            StringBuilder sb=new StringBuilder();
            
            PriorityQueue<Character> pq=new PriorityQueue<>(new Comparator<Character>(){
                
                public int compare(Character c1, Character c2)
                {
                    return postOrder.get(c2).compareTo(postOrder.get(c1));
                }
            });
            
            for(char c:VS.keySet())
                pq.add(c);
            
            while(!pq.isEmpty())
                sb.append(pq.poll());
            
            return sb.toString();
        }
    }
    
    public String alienOrder(String[] words) {
        
        // If in the dict the prev word is longer than the following word and the following word matches exactly
        // with the characters from 0 to the length of the following word, then there is no legal order
        // For example, ["abc","ab"]
        for(int i=0;i<words.length-1;i++)
        {
            if(words[i].length()>words[i+1].length()&&words[i+1].equals(words[i].substring(0,words[i+1].length())))
                return "";
        }
        
        List<char[]> edges=makeEdges(words);
        //print(edges);
        
        Graph g=new Graph(edges);
        
        return g.makeOrder();
    }
    
    private void print(List<char[]> A)
    {   
        for(char[] c:A)
        {
            System.out.println(c[0]+"->"+c[1]);
                
        }
    }
    
    private void printMap(Map<Character,Boolean> map)
    {
        for(char c:map.keySet())
            System.out.println(c+":"+map.get(c));
    }
    
    private List<char[]> makeEdges(String[] words)
    {
        List<char[]> ans=new ArrayList<>();
        Map<Character,Boolean> visited=new HashMap<>();
        
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words[i].length();j++)
                if(!visited.containsKey(words[i].charAt(j)))
                    visited.put(words[i].charAt(j),false);
        }
        
        //printMap(visited);
        
        for(int i=0;i<words.length-1;i++)
        {
            String s1=words[i];
            String s2=words[i+1];
            
            int len=Math.min(s1.length(),s2.length());
            
            for(int j=0;j<len;j++)
            {
                char c1=s1.charAt(j);
                char c2=s2.charAt(j);
                
                if(c1!=c2)
                {
                    ans.add(new char[]{c1,c2});
                    visited.put(c1,true);
                    visited.put(c2,true);
                    break;
                }
            }

        }
        
        for(char c:visited.keySet())
        {
            if(!visited.get(c))
            {
                visited.put(c,true);
                ans.add(new char[]{c,c});
            }
        }
        
        return ans;
    }
}