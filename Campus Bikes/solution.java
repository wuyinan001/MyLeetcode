class Solution {
    
    boolean[] visited;
    PriorityQueue<Pair> pq=new PriorityQueue(new Comparator<Pair>(){
        
        public int compare(Pair p1, Pair p2)
        {
            if(p1.d==p2.d)
            {
                if(p1.w==p2.w)
                    return p1.b-p2.b;
                
                return  p1.w-p2.w;
            }
            
            return p1.d-p2.d;
        }
        
    });
    
    private class Pair
    {
        int w,b,d;
        
        public Pair(int w, int b, int d)
        {
            this.w=w;
            this.b=b;
            this.d=d;
        }
    }
    
    // Find the available bike (visited[id]==false) for a given worker with the smallest distance and add to the heap
    private void helper(int[][] workers, int worker_id, int[][] bikes)
    {
        int min=Integer.MAX_VALUE, min_id=-1;
        
        for(int i=0;i<bikes.length;i++)
        {
            if(!visited[i])
            {
                int dist=Math.abs(workers[worker_id][0]-bikes[i][0])+Math.abs(workers[worker_id][1]-bikes[i][1]);
                
                if(min>dist)
                {
                    min_id=i;
                    min=dist;
                }
            }
        }
        
        pq.add(new Pair(worker_id,min_id,min));
        
    }
    
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        
        int n=workers.length, m=bikes.length;
        visited=new boolean[m];
        
        for(int i=0;i<n;i++)
            helper(workers,i,bikes);
        
        int[] ans=new int[n];
        int count=0;
        
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            
            if(!visited[p.b])
            {
                ans[p.w]=p.b;
                visited[p.b]=true;
                count++;
            }
            else
                helper(workers,p.w,bikes);
            
            if(count==n)
                break;
        }
        
        return ans;
    }
}