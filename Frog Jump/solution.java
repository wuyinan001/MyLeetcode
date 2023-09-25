class Solution {
    public boolean canCross(int[] stones) {
        
        // Key: the stone position; Value: the set of jumps that can reach to the stone position at Key
        Map<Integer,Set<Integer>> map=new HashMap();
        
        int n=stones.length;
        
        for(int i=0;i<n;i++)
            map.put(stones[i],new HashSet());
        
        map.get(stones[0]).add(0);
        
        for(int i=0;i<n-1;i++)
        {
            for(int k:map.get(stones[i]))
            {
                for(int j=k-1;j<=k+1;j++)
                {
                    if(j>0&&map.containsKey(stones[i]+j))
                        map.get(stones[i]+j).add(j);
                }
            }
        }
        
        return map.get(stones[n-1]).size()>0;
    }
}