class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        
        int n=rowSum.length, m=colSum.length;
        
        int[][] ans=new int[n][m];
        
        Map<Integer,Integer> rowMap=new HashMap();
        Map<Integer,Integer> colMap=new HashMap();
        
        
        PriorityQueue<Map.Entry<Integer,Integer>> rpq=new PriorityQueue(new Comparator<Map.Entry<Integer,Integer>>(){
            
            public int compare(Map.Entry<Integer,Integer> p1, Map.Entry<Integer,Integer> p2)
            {
                return p1.getValue()-p2.getValue();
            }
            
        });
        
        
        PriorityQueue<Map.Entry<Integer,Integer>> cpq=new PriorityQueue(new Comparator<Map.Entry<Integer,Integer>>(){
            
            public int compare(Map.Entry<Integer,Integer> p1, Map.Entry<Integer,Integer> p2)
            {
                return p1.getValue()-p2.getValue();
            }
            
        });
        
        for(int i=0;i<n;i++)
            if(rowSum[i]!=0)
                rowMap.put(i,rowSum[i]);
        
        for(int i=0;i<m;i++)
            if(colSum[i]!=0)
                colMap.put(i,colSum[i]);
        
        for(Map.Entry<Integer,Integer> e:rowMap.entrySet())
                rpq.add(e);
        
        for(Map.Entry<Integer,Integer> e:colMap.entrySet())
                cpq.add(e);
        
        while(!rpq.isEmpty()&&!cpq.isEmpty())
        {
            Map.Entry<Integer,Integer> row=rpq.peek();
            Map.Entry<Integer,Integer> col=cpq.peek();
            
            int min=Math.min(row.getValue(),col.getValue());
            
            ans[row.getKey()][col.getKey()]=min;
            
            row.setValue(row.getValue()-min);
            col.setValue(col.getValue()-min);
            
            if(row.getValue()==0)
                rpq.poll();
            
            if(col.getValue()==0)
                cpq.poll();
            
        }
        
        return ans;
    }
}