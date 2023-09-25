class Solution {
    public String frequencySort(String s) {
        
        if(s.equals(""))
            return "";
        
        Map<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
            
        PriorityQueue<Character> pq=new PriorityQueue<>(new Comparator<Character>(){
            
            public int compare(Character c1, Character c2)
            {
                return map.get(c2).compareTo(map.get(c1));
            }

        });
        
        for(char c:map.keySet())
        {
            pq.add(c);
        }
        
        StringBuilder sb=new StringBuilder();
        
        while(!pq.isEmpty())
        {
            char c=pq.poll();
            int n=map.get(c);
            
            for(int i=1;i<=n;i++)
            {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}