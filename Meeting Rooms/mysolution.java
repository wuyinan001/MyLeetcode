class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if(intervals.length==0)
            return true;
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b)
            {
                return a[0]-b[0];
            }
            
        });
        
        for(int i=1;i<intervals.length;i++)
        {
            int x=intervals[i-1][1],y=intervals[i][0];
            
            if(x>y)
                return false;
        }
        
        return true;
        
    }
}