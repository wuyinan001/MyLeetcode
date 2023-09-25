class Solution {
    public String longestWord(String[] words) {
        
        PriorityQueue<String> pq=new PriorityQueue(new Comparator<String>(){
            
            public int compare(String s1, String s2)
            {
                if(s1.length()==s2.length())
                    return  s1.compareTo(s2);
                
                return s2.length()-s1.length();
            }
            
        });
        
        Set<String> set=new HashSet();
        
        for(String s:words)
        {
            set.add(s);
            pq.add(s);
        }
        
        while(!pq.isEmpty())
        {
            String s=pq.poll();
            int i=0;
            
            for(;i<s.length();i++)
            {
                if(!set.contains(s.substring(0,i+1)))
                    break;
            }
            
            if(i==s.length())
                return s;
        }
        
        
        return "";
    }
}