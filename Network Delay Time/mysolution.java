class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer,Integer> dist=new HashMap();
        
        for(int i=1;i<=n;i++)
            dist.put(i,Integer.MAX_VALUE);
        
        dist.put(k,0);
        
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return dist.get(a1)-dist.get(a2);
            }
            
        });
        
        int ans=0;
        
        for(int i=1;i<=n;i++)
            pq.add(i);
        
        List<int[]>[] adj=new List[n+1];
        
        for(int i=1;i<=n;i++)
            adj[i]=new ArrayList();
        
        for(int[] edge:times)
        {
            adj[edge[0]].add(new int[]{edge[1],edge[2]});
        }
        
        while(!pq.isEmpty())
        {
            int u=pq.poll();
            
            ans=Math.max(ans,dist.get(u));
            
            for(int[] v:adj[u])
            {
                if(dist.get(v[0])>dist.get(u)+v[1])
                {
                    dist.put(v[0],dist.get(u)+v[1]);
                    pq.remove(v[0]);
                    pq.add(v[0]);
                }
            }
        }
        
        for(int i=1;i<=n;i++)
            if(dist.get(i)==Integer.MAX_VALUE)
                return -1;
        
        return ans;
    }
}