class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer,List<int[]>> adj=new HashMap();
        
        for(int[] flight:flights)
        {
            if(!adj.containsKey(flight[0]))
                adj.put(flight[0],new ArrayList());
            
            if(!adj.containsKey(flight[1]))
                adj.put(flight[1],new ArrayList());
            
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        
        int[] dist=new int[n];
        
        for(int i=0;i<n;i++)
            dist[i]=Integer.MAX_VALUE;
        
        dist[src]=0;
        
        Queue<int[]> queue=new LinkedList();
        
        // 1: node; 2: dist from src at current iteration; 
        queue.add(new int[]{src,0});
        
        int stop=0, ans=Integer.MAX_VALUE;
        
        while(!queue.isEmpty())
        {
            if(stop>k+1)
                break;
            
            int size=queue.size();
            
            for(int i=1;i<=size;i++)
            {
                int[] node=queue.remove();
                
                if(node[0]==dst)
                    ans=Math.min(ans,node[1]);
                
                for(int[] neigh:adj.get(node[0]))
                {
                    if(dist[neigh[0]]>neigh[1]+node[1])
                    {
                        dist[neigh[0]]=neigh[1]+node[1];
                        queue.add(new int[]{neigh[0],dist[neigh[0]]});
                    }
                }
            }
            
            stop++;
        }
        
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}