class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        
        Map<Pair<Integer,Integer>,List<int[]>> adj=new HashMap();
        Map<Pair<Integer,Integer>,Integer> dist=new HashMap();
        
        for(int i=0;i<n;i++)
        {
            adj.put(new Pair(i,0),new ArrayList());
            adj.put(new Pair(i,1),new ArrayList());
            dist.put(new Pair(i,0),9999);
            dist.put(new Pair(i,1),9999);
        }
            
        for(int[] edge:red_edges)
        {
            adj.get(new Pair(edge[0],0)).add(new int[]{edge[1],0});
            adj.get(new Pair(edge[0],1)).add(new int[]{edge[1],0});
        }
        
        for(int[] edge:blue_edges)
        {
            adj.get(new Pair(edge[0],0)).add(new int[]{edge[1],1});
            adj.get(new Pair(edge[0],1)).add(new int[]{edge[1],1});
        }
        
        Queue<Pair<Integer,Integer>> queue=new LinkedList();
        
        queue.add(new Pair(0,0));
        dist.put(new Pair(0,0),0);
        
        boolean red=true;
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            if(red)
            {
                for(int i=1;i<=size;i++)
                {
                    Pair<Integer,Integer> temp=queue.remove();

                    for(int[] v:adj.get(temp))
                    {
                        if(v[1]==0&&dist.get(new Pair(v[0],0))>1+dist.get(temp))
                        {
                            dist.put(new Pair(v[0],0),1+dist.get(temp));
                            queue.add(new Pair(v[0],0));
                        }
                    }
                }
            }
            else
            {
                for(int i=1;i<=size;i++)
                {
                    Pair<Integer,Integer> temp=queue.remove();

                    for(int[] v:adj.get(temp))
                    {
                        if(v[1]==1&&dist.get(new Pair(v[0],1))>1+dist.get(temp))
                        {
                            dist.put(new Pair(v[0],1),1+dist.get(temp));
                            queue.add(new Pair(v[0],1));
                        }
                    }
                }
            }
        
            red=!red;
        }
        
        
        queue.add(new Pair(0,0));
        red=false;
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            if(red)
            {
                for(int i=1;i<=size;i++)
                {
                    Pair<Integer,Integer> temp=queue.remove();

                    for(int[] v:adj.get(temp))
                    {
                        if(v[1]==0&&dist.get(new Pair(v[0],0))>1+dist.get(temp))
                        {
                            dist.put(new Pair(v[0],0),1+dist.get(temp));
                            queue.add(new Pair(v[0],0));
                        }
                    }
                }
            }
            else
            {
                for(int i=1;i<=size;i++)
                {
                    Pair<Integer,Integer> temp=queue.remove();

                    for(int[] v:adj.get(temp))
                    {
                        if(v[1]==1&&dist.get(new Pair(v[0],1))>1+dist.get(temp))
                        {
                            dist.put(new Pair(v[0],1),1+dist.get(temp));
                            queue.add(new Pair(v[0],1));
                        }
                    }
                }
            }
        
            red=!red;
        }
        
        int[] ans=new int[n];
        
        for(int i=0;i<n;i++)
        {
            ans[i]=Math.min(dist.get(new Pair(i,0)),dist.get(new Pair(i,1)));
            if(ans[i]==9999)
                ans[i]=-1;
        }
            
        
        return ans;
    }
}