class Solution {
    
    Map<String,List<String>> adj=new HashMap();
    Map<String,Boolean> visited=new HashMap();
    Map<String,Integer> postOrder=new HashMap();
    int clock=0;
    
    private void buildGraph(int n, int k, StringBuilder sb, int index)
    {
        if(index==n)
        {
            String node=sb.toString();
            adj.put(node,new ArrayList());
            visited.put(node,false);
            postOrder.put(node,-1);
            return;
        }
        
        for(int i=0;i<k;i++)
        {
            int l=sb.length();
            sb.append(i);
            buildGraph(n,k,sb,index+1);
            sb.deleteCharAt(l);
        }
    }
    
    private void dfs(String s)
    {
        visited.put(s,true);
        clock++;
        
        for(String v:adj.get(s))
        {
            if(!visited.get(v))
                dfs(v);
        }
        
        clock++;
        postOrder.put(s,clock);
    }
    
    public String crackSafe(int n, int k) {
        
        buildGraph(n,k,new StringBuilder(),0);
        
        for(String s:adj.keySet())
        {
            String str=s.substring(1);
            for(int j=0;j<k;j++)
            {
                adj.get(s).add(str+j);
            }
        }
        
        for(String s:adj.keySet())
        {
            if(!visited.get(s))
                dfs(s);
        }
        
        StringBuilder sb=new StringBuilder();
        
        List<String> list=new ArrayList(postOrder.keySet());
        
        Collections.sort(list,new Comparator<String>(){
            
            public int compare(String s1, String s2)
            {
                return postOrder.get(s2)-postOrder.get(s1);
            }
            
        });
        
        sb.append(list.get(0));
        
        for(int i=1;i<list.size();i++)
        {
            sb.append(list.get(i).charAt(n-1));
        }
        
        return sb.toString();
    }
}