class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        
        int a=times[targetFriend][0], n=times.length;
        
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a1[1]-a2[1];
            }
            
        });
        
        int next=0;
        Set<Integer> set=new HashSet();
        
        Arrays.sort(times, new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a1[0]-a2[0];
            }
        });
        
        for(int[] time:times)
        {
            while(!pq.isEmpty()&&pq.peek()[1]<=time[0])
            {
                int seat=pq.peek()[2];
                set.remove(seat);
                next=Math.min(next,seat);
                pq.poll();
            }
            
            if(time[0]==a)
            {
                return next;
            }
            
            pq.add(new int[]{time[0],time[1],next});
            set.add(next);
            
            while(set.contains(next))
                next++;
        }
        
        return -1;
        
    }
}