class Solution {
    
    private boolean oneDiff(String s1, String s2)
    {
        int diff=0;
        
        for(int i=0;i<8;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
        }
        
        return diff==1;
    }
    
    public int minMutation(String start, String end, String[] bank) {
        
        Set<String> set=new HashSet();
        
        for(String s:bank)
            set.add(s);
        
        if(!set.contains(end))
            return -1;
            
        int dist=0;
        
        Map<String,List<String>> adj=new HashMap();
        Map<String,Boolean> visited=new HashMap();
        
        adj.put(start,new ArrayList());
        visited.put(start,false);
        
        for(String g:bank)
        {
            adj.put(g,new ArrayList());
            visited.put(g,false);
        }
        
        for(String g:bank)
        {
            if(oneDiff(start,g))
            {
                adj.get(start).add(g);
                adj.get(g).add(start);
            }
        }
        
        int n=bank.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(oneDiff(bank[i],bank[j]))
                {
                    adj.get(bank[i]).add(bank[j]);
                    adj.get(bank[j]).add(bank[i]);
                }  
            }
        }
        
        Queue<String> queue=new LinkedList();
        
        queue.add(start);
        visited.put(start,true);
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int i=1;i<=size;i++)
            {
                String t=queue.remove();
                
                if(t.equals(end))
                    return dist;
                
                for(String v:adj.get(t))
                {
                    if(!visited.get(v))
                    {
                        visited.put(v,true);
                        queue.add(v);
                    }
                }
            }
            
            dist++;
        }
        
        return -1;
    }
}