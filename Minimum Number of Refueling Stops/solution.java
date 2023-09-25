class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return a2-a1;
            }
            
        });
        
        int prev=0, tank=startFuel;
        int ans=0;
        
        for(int[] station:stations)
        {
            int location=station[0];
            int gas=station[1];
            
            tank-=location-prev;
            
            while(!pq.isEmpty()&&tank<0)
            {
                tank+=pq.poll();
                ans++;
            }
            
            if(tank<0)
                return -1;
            
            pq.add(gas);
            prev=location;
        }
        
        tank-=target-prev;
        
        while(!pq.isEmpty()&&tank<0)
        {
            tank+=pq.poll();
            ans++;
        }

        if(tank<0)
            return -1;
        
        return ans;
    }
}