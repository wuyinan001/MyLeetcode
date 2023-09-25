class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> map=new HashMap<>();
        
        for(String s:words)
            map.put(s,map.getOrDefault(s,0)+1);
        
        List<Map.Entry<String,Integer>> list=new LinkedList<>(map.entrySet());
        
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>()
                         {
                             public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2)
                             {
                                 if(o1.getValue()==o2.getValue())
                                     return o1.getKey().compareTo(o2.getKey());
                                 return o2.getValue().compareTo(o1.getValue());
                             }
                         });
        
        //Collections.reverse(list);
        //print(list);
        
        List<String> ans=new LinkedList<>();
        
        int count=0;
        
        for(Map.Entry<String,Integer> i:list)
        {
            ans.add(i.getKey());
            count++;
            
            if(count>=k)
                break;
        }
        
        return ans;
    }
    
    private void print(List<Map.Entry<String,Integer>> list)
    {
        for(Map.Entry<String,Integer> a:list)
            System.out.println(a.getKey());
    }
}