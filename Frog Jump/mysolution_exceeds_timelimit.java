class Solution {
    
    public boolean canCross(int[] stones) {
        
        if(stones[1]!=1)
            return false;
        
        int n=stones.length;
        
        if(n==2)
            return true;
        
        Queue<int[]> queue=new LinkedList();
        Map<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<n;i++)
            map.put(stones[i],i);
        
        queue.add(new int[]{1,1});
        
        
        while(!queue.isEmpty())
        {
            int[] temp=queue.remove();
            
            for(int k=temp[1]-1;k<=temp[1]+1;k++)
            {
                if(k>0&&map.containsKey(stones[temp[0]]+k))
                {
                    int index=map.get(stones[temp[0]]+k);
                    if(index==n-1)
                        return true;
                    
                    queue.add(new int[]{index,k});
                }
            }
        }
        
        return false;
    }
}