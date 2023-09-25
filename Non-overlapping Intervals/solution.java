class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length==0)
            return 0;
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                if(a1[0]==a2[0])
                    return a1[1]-a2[1];
                return  a1[0]-a2[0];
            }
        });
            
        int n=intervals.length;
        
        // dp[i]: max num of non overlapping intervals from intervals[0] to intervals[i]
        int[] dp=new int[n];
        int max=1;
        
        dp[0]=1;
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(intervals[j][1]<=intervals[i][0]&&dp[i]<dp[j]+1)
                    dp[i]=dp[j]+1;
            }
            
            max=Math.max(max,dp[i]);
        }
        
        return n-max;
    }
}