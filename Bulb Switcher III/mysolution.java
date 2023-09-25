class Solution {
    public int numTimesAllBlue(int[] light) {
        
        PriorityQueue<Integer> pq=new PriorityQueue();
        
        int ans=0, n=light.length, max=0;
        
        for(int i=0;i<n;i++)
        {
            pq.add(light[i]);
            
            max=Math.max(max,light[i]);
            
            //int top=pq.peek();
            
            if(pq.peek()==1&&pq.size()==max)
                ans++;
        }
        
        return ans;
    }
}