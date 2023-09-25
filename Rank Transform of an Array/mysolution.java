class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        
        for(int i=0;i<n;i++)
            map.put(i,arr[i]);
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>(){
            
            public int compare(Map.Entry<Integer,Integer> m1, Map.Entry<Integer,Integer> m2)
            {
                return m1.getValue()-m2.getValue();
            }
        });
        
        for(Map.Entry<Integer,Integer> m:map.entrySet())
            pq.add(m);
        
        int[] rank=new int[n];
        
        if(n==0)
            return rank;
        
        int curr_rank=1, prev=pq.peek().getValue();
        
        while(!pq.isEmpty())
        {
            Map.Entry<Integer,Integer> m=pq.poll();
            
            if(m.getValue()>prev)
                curr_rank++;
            
            rank[m.getKey()]=curr_rank;
            prev=m.getValue();
        }
        
        
        return rank;
    }
}