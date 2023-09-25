class Solution {
    
    Map<String,List<String>> map=new HashMap();
    List<String> ans=new ArrayList();
    
    private void dfs(String origin)
    {
        List<String> list=map.get(origin);
        
        while(!list.isEmpty())
        {
            String dest=list.remove(0);
            dfs(dest);
        }
        
        ans.add(0,origin);
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        for(List<String> list:tickets)
        {
            String s1=list.get(0), s2=list.get(1);
            
            if(!map.containsKey(s1))
            {
                List<String> temp=new ArrayList();
                temp.add(s2);
                map.put(s1,temp);
            }
            else
                map.get(s1).add(s2);
            
            if(!map.containsKey(s2))
            {
                List<String> temp=new ArrayList();
                map.put(s2,temp);
            }
                
        }
        
        for(Map.Entry<String,List<String>> m:map.entrySet())
        {
            Collections.sort(m.getValue());
        }
        
        dfs("JFK");
        
        return ans;
    
    }
}