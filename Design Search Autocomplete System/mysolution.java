class AutocompleteSystem {
    
    Map<String,Integer> map;
    PriorityQueue<String> pq;
    StringBuilder inputStr;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        
        map=new HashMap();
        
        for(int i=0;i<sentences.length;i++)
            map.put(sentences[i],times[i]);
        
        pq=new PriorityQueue(new Comparator<String>(){
            
            public int compare(String s1, String s2)
            {
                if(map.get(s1)==map.get(s2))
                    return s1.compareTo(s2);
                
                return map.get(s2)-map.get(s1);
            }
            
        });
        
        inputStr=new StringBuilder();
    }
    
    public List<String> input(char c) {
        
        List<String> ans=new ArrayList();
        
        if(c=='#')
        {
            map.put(inputStr.toString(),map.getOrDefault(inputStr.toString(),0)+1);
            inputStr=new StringBuilder();
            return ans;
        }
        
        inputStr.append(c);
            
        
        String s=inputStr.toString();
        int n=s.length();
        
        for(String key:map.keySet())
        {
            if(key.length()>=n&&s.equals(key.substring(0,n)))
                pq.add(key);
        }
        
        int count=0;
        
        while(!pq.isEmpty())
        {
            ans.add(pq.poll());
            count++;
            
            if(count==3)
                break;
        }
        
        pq.clear();
        
        return ans;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */