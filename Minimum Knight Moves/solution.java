class Solution {
    public int minKnightMoves(int x, int y) {
        
        if(x==0&&y==0)
            return 0;
        
        // Symmetric logic
        x=Math.abs(x);
        y=Math.abs(y);
        
        Queue<Pair<Integer,Integer>> queue=new LinkedList();
        Set<Pair<Integer,Integer>> set=new HashSet();
        int[][] dir = new int[][]{{2, 1}, {-2, 1}, {2, -1},
				{-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
        
        queue.add(new Pair(0,0));
        set.add(queue.peek());
        int ans=0;
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            
            for(int i=0;i<n;i++)
            {
                Pair<Integer,Integer> temp=queue.remove();
                int x0=temp.getKey(), y0=temp.getValue();
                
                for(int k=0;k<8;k++)
                {
                    int x1=Math.abs(x0+dir[k][0]), y1=Math.abs(y0+dir[k][1]);
                    
                    if(x1==x&&y1==y)
                        return ans+1;
                    
                    Pair<Integer,Integer> pair=new Pair(x1,y1);
                    
                    if(!set.contains(pair)&&(x1+y1)<=300)
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