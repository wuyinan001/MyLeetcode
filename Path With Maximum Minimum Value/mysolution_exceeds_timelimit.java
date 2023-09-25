class Solution {
    public int maximumMinimumPath(int[][] A) {
        
        int n=A.length, m=A[0].length;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        Map<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                map.put(i*m+j,-1);
            }
        
        map.put(0,A[0][0]);
        
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return map.get(a2)-map.get(a1);
            }
            
        });
        
        for(int i:map.keySet())
            pq.add(i);
        
        while(!pq.isEmpty())
        {
            int index=pq.poll();
            int i=index/m, j=index%m;
            
            for(int k=0;k<4;k++)
            {
                int x=i+dir[k][0], y=j+dir[k][1];
                int index2=x*m+y;
                
                if(x>=0&&x<n&&y>=0&&y<m&&map.get(index2)<map.get(index))
                {
                    map.put(index2,Math.min(map.get(index),A[x][y]));
                    pq.add(index2);
                }
                    
            }
        }
        
        return map.get(n*m-1);
    }
}