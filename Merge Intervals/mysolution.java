class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n=intervals.length;
        
        if(n<=1)
            return intervals;
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            
            public int compare(int[] a,int[] b)
            {
                if(a[0]==b[0])
                    return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        
        return mergeSortIntervals(intervals,0,n-1);
        
    }
    
    private int[][] mergeSortIntervals(int[][] intervals, int lo, int hi)
    {
        if(lo>=hi)
            return new int[][]{intervals[lo]};
        
        int[][] temp=mergeSortIntervals(intervals,lo+1,hi);
        
        int[] curr=new int[]{intervals[lo][0],intervals[lo][1]};
        
        //sec: the start index of temp that appends after intervals[0]
        int sec;
        
        for(sec=0;sec<temp.length;sec++)
        {   
            if(curr[1]<temp[sec][0])
            {
                break;
            }
            else
            {
                curr[1]=Math.max(curr[1],temp[sec][1]);
            }
        }
        
        
        int[][] ans=new int[1+temp.length-sec][2];
        
        ans[0]=new int[]{curr[0],curr[1]};
        
        for(int i=1;i<ans.length;i++)
        {
            ans[i]=new int[]{temp[sec+i-1][0],temp[sec+i-1][1]};
        }
        
        return ans;
    }
    
}