class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        LinkedList<int[]> merged=new LinkedList<>();
        boolean inserted=false;
        
        for(int[] interval:intervals)
        {
            if(!inserted&&newInterval[0]<=interval[0])
            {
                if(merged.isEmpty()||merged.getLast()[1]<newInterval[0])
                    merged.add(newInterval);
                else
                    merged.getLast()[1]=Math.max(merged.getLast()[1],newInterval[1]);
                
                inserted=true;
            }
            
            if(merged.isEmpty()||merged.getLast()[1]<interval[0])
                merged.add(interval);
            else
                merged.getLast()[1]=Math.max(merged.getLast()[1],interval[1]);
        }
        
        if(!inserted)
        {
            if(merged.isEmpty()||merged.getLast()[1]<newInterval[0])
                merged.add(newInterval);
            else
                merged.getLast()[1]=Math.max(merged.getLast()[1],newInterval[1]);

            inserted=true;
        }
        
        return merged.toArray(new int[merged.size()][]);
        
    }
}