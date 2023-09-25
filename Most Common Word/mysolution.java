class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        String[] strs=paragraph.split("[ !?',;.']");
        
        for(String s:strs)
            System.out.println(s);
        
        Map<String,Integer> freq=new HashMap();
        Set<String> set=new HashSet();
        
        for(String s:banned)
            set.add(s);
        
        for(String s:strs)
        {
            s=s.toLowerCase();
            if(!set.contains(s)&&!s.equals(""))
                freq.put(s,freq.getOrDefault(s,0)+1);
        }
        
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue(new Comparator<Map.Entry<String,Integer>>(){
            
            public int compare(Map.Entry<String,Integer> m1,Map.Entry<String,Integer> m2)
            {
                if(m1.getValue()==m2.getValue())
                    return m1.getKey().compareTo(m2.getKey());
                return m2.getValue()-m1.getValue();
            }
            
        });
        
        for(Map.Entry<String,Integer> m:freq.entrySet())
            pq.add(m);
        
        return pq.peek().getKey();
    }
}