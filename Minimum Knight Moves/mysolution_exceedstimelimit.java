class Solution {
    public int minKnightMoves(int x, int y) {
        
        // Symmetric logic
        x=Math.abs(x);
        y=Math.abs(y);
        
        Queue<Pair<Integer,Integer>> queue=new LinkedList();
        Set<Pair<Integer,Integer>> set=new HashSet();
        int[][] dir={{2,1},{1,2},{-2,1},{-1,2},{2,-1},{1,-2},{-2,-1},{-1,-2}};
        
        queue.add(new Pair(0,0));
        set.add(new Pair(0,0));
        int ans=0;
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            
            for(int i=0;i<n;i++)
            {
                Pair<Integer,Integer> temp=queue.remove();
                
                if(Math.abs(temp.getKey())==x&&Math.abs(temp.getValue())==y)
                    return ans;
                
                for(int k=0;k<8;k++)
                {
                    Pair<Integer,Integer> pair=new Pair(temp.getKey()+dir[k][0],temp.getValue()+dir[k][1]);
                    if(!set.contains(pair)&&(Math.abs(pair.getKey())+Math.abs(pair.getValue()))<=300)
                    {
                        queue.add(pair);
                        set.add(pair);
                    }
                }
                
            }
            
            ans++;
        }
        
        return -1;
    }
}