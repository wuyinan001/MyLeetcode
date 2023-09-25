class Solution {
    
    private int dist(int x1, int y1, int x2, int y2)
    {
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
    
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        
        int n=workers.length, m=bikes.length;
        
        int[] ans=new int[n];
        
        if(n==0)
            return ans;
        
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                if(dist(workers[a1[0]][0],workers[a1[0]][1],bikes[a1[1]][0],bikes[a1[1]][1])==dist(workers[a2[0]][0],workers[a2[0]][1],bikes[a2[1]][0],bikes[a2[1]][1])) 
                {
                    if(a1[0]==a2[0])
                        return a1[1]-a2[1];
                    
                    return a1[0]-a2[0];
                }
                
                return dist(workers[a1[0]][0],workers[a1[0]][1],bikes[a1[1]][0],bikes[a1[1]][1])-dist(workers[a2[0]][0],workers[a2[0]][1],bikes[a2[1]][0],bikes[a2[1]][1]);
            }
            
        });
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                pq.add(new int[]{i,j});
            }
                
        }
        
        Set<Integer> set1=new HashSet();
        Set<Integer> set2=new HashSet();
        
        for(int i =0;i<n;i++)
            set1.add(i);
        
        for(int i =0;i<m;i++)
            set2.add(i);
        
        while(!pq.isEmpty())
        {
            int[] index=pq.poll();
            
            if(set1.contains(index[0])&&set2.contains(index[1]))
            {
                ans[index[0]]=index[1];
                set1.remove(index[0]);
                set2.remove(index[1]);
            }
                
        }
        
        return ans;
    }
}