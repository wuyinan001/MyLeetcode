class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        
        Set<Pair<Integer,Integer>> set=new HashSet();
        
        int sum=0;
        
        for(int[] r:rectangles)
        {
            sum+=(r[2]-r[0])*(r[3]-r[1]);
            Pair<Integer,Integer> p1=new Pair(r[0],r[1]);
            Pair<Integer,Integer> p2=new Pair(r[0],r[3]);
            Pair<Integer,Integer> p3=new Pair(r[2],r[1]);
            Pair<Integer,Integer> p4=new Pair(r[2],r[3]);
            
            if(set.contains(p1))
                set.remove(p1);
            else
                set.add(p1);
            
            if(set.contains(p2))
                set.remove(p2);
            else
                set.add(p2);
            
            if(set.contains(p3))
                set.remove(p3);
            else
                set.add(p3);
            
            if(set.contains(p4))
                set.remove(p4);
            else
                set.add(p4);
        }
        
        if(set.size()!=4)
            return false;
        
        int x_min=Integer.MAX_VALUE, x_max=Integer.MIN_VALUE, y_min=Integer.MAX_VALUE, y_max=Integer.MIN_VALUE;
        for(Pair<Integer,Integer> p:set)
        {
            x_min=Math.min(x_min,p.getKey());
            x_max=Math.max(x_max,p.getKey());
            y_min=Math.min(y_min,p.getValue());
            y_max=Math.max(y_max,p.getValue());
        }
        
        int total_area=(x_max-x_min)*(y_max-y_min);
        
        return sum==total_area;
    }
}