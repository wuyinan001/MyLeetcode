class Solution {
    public String customSortString(String S, String T) {
        
        Map<Character, Integer> map=new HashMap();
        
        for(int i=0;i<S.length();i++)
            map.put(S.charAt(i),i);
        
        PriorityQueue<Character> pq=new PriorityQueue(new Comparator<Character>(){
            
            public int compare(Character c1, Character c2)
            {
                return map.get(c1)-map.get(c2);
            }
            
        });
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<T.length();i++)
        {
            char c=T.charAt(i);
            
            if(map.containsKey(c))
                pq.add(c);
            else
                sb.append(c);
        }
        
        StringBuilder ans=new StringBuilder();
        
        while(!pq.isEmpty())
            ans.append(pq.poll());
        
        return ans.toString()+sb.toString();
    }
}