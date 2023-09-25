class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length==0)
            return 0;
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b)
            {
                return a[0]-b[0];
            }
        });
        
        PriorityQueue<Integer> room=new PriorityQueue<>();
        
        for(int[] interval:intervals)
        {
            if(room.isEmpty()||interval[0]<room.peek())
                room.add(interval[1]);
            else
            {
                room.poll();
                room.add(interval[1]);
            }
        }
        
        return room.size();
    }
}