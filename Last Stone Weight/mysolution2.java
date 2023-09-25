class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return a2-a1;
            }
            
        });
        
        for(int i:stones)
            pq.add(i);
        
        while(pq.size()>=2)
        {
            int y=pq.poll();
            int x=pq.poll();
            
            pq.add(y-x);
        }
        
        return pq.peek();
    }
}