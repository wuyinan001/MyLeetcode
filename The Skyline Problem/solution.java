class Solution {
    
    private class Position
    {
        int x,y;
        char label;
        
        public Position(int x, int y, char label)
        {
            this.x=x;
            this.y=y;
            this.label=label;
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<Position> list=new ArrayList();
        
        for(int[] b:buildings)
        {
            list.add(new Position(b[0],b[2],'s'));
            list.add(new Position(b[1],b[2],'e'));
        }
        
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return a2-a1;
            }
            
        });
        
        Collections.sort(list,new Comparator<Position>(){
            
            public int compare(Position p1, Position p2)
            {
                if(p1.x==p2.x)
                {
                    if(p1.label!=p2.label)
                        return p2.label-p1.label;
                    else if(p1.label=='s')
                        return p2.y-p1.y;
                    else
                        return p1.y-p2.y;
                }
                else
                    return p1.x-p2.x;
            }
            
        });
        
        int max=0;
        
        pq.add(max);
        
        List<List<Integer>> ans=new ArrayList();
        
        for(Position p:list)
        {
            if(p.label=='s')
            {
                pq.add(p.y);
                if(max!=pq.peek())
                {
                    List<Integer> l=new ArrayList();
                    l.add(p.x);
                    l.add(pq.peek());
                    ans.add(l);
                    max=pq.peek();
                }
            }
            else
            {
                pq.remove(p.y);
                if(max!=pq.peek())
                {
                    List<Integer> l=new ArrayList();
                    l.add(p.x);
                    l.add(pq.peek());
                    ans.add(l);
                    max=pq.peek();
                }
            }
        }
        
        return ans;
    }
}