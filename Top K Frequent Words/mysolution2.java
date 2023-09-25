class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String,Integer> map=new HashMap<>();
        List<String> ans=new ArrayList<>();
        
        for(String word:words)
            map.put(word,map.getOrDefault(word,0)+1);
        
        PriorityQueue<String> heap=new PriorityQueue<>(new Comparator<String>(){
            
            public int compare(String s1, String s2)
            {
                if(map.get(s1)==map.get(s2))
                    return s1.compareTo(s2);
                return map.get(s2).compareTo(map.get(s1));
            }
        });
        
        for(String word:map.keySet())
        {
            heap.offer(word);
        }
        
        while(k>0)
        {
            ans.add(heap.poll());
            k--;
        }
        
        return ans;
    }
}