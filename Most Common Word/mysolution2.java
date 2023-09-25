class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        Map<String,Integer> freq=new HashMap();
        Set<String> set=new HashSet();
        
        for(String s:banned)
            set.add(s);
        
        String[] strs=paragraph.split("[ !?',;.]");
        
        /*
        for(String s:strs)
            System.out.println(s);*/
        
        for(String s:strs)
        {
            s=s.toLowerCase();
            if(!s.equals(""))
                freq.put(s,freq.getOrDefault(s,0)+1);
        }
            
        
        PriorityQueue<String> pq=new PriorityQueue(new Comparator<String>(){
            
            public int compare(String s1, String s2)
            {
                if(freq.get(s1)==freq.get(s2))
                    return s1.compareTo(s2);
                return freq.get(s2)-freq.get(s1);
            }
        });
        
        for(String s:freq.keySet())
            pq.add(s);
        
        while(!pq.isEmpty())
        {
            String s=pq.poll();
            
            if(!set.contains(s))
                return s;
        }
        
        return null;
    }
}