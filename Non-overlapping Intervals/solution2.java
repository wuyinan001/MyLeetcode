class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a1[0]-a2[0];
            }
            
        });
        
        int n=intervals.length;
        int prev=0, removed=0;
        
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]>=intervals[prev][1])
            {
                prev=i;
            }
            else if(intervals[i][1]<=intervals[prev][1])
            {
                prev=i;
                removed++;
            }
            else
            {
                removed++;
            }
        }
        
        return removed;
    }
}