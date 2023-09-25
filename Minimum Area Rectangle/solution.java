class Solution {
    public int minAreaRect(int[][] points) {
        
        int n=points.length;
        
        Set<Pair<Integer,Integer>> set=new HashSet();
        
        for(int[] point:points)
        {
            set.add(new Pair(point[0],point[1]));
        }
        
        int ans=Integer.MAX_VALUE;
        
        for(int[] point1:points)
        {
            for(int[] point2:points)
            {
                if(point1[0]==point2[0]||point1[1]==point2[1])
                    continue;
                
                Pair<Integer,Integer> p1=new Pair(point1[0],point2[1]);
                Pair<Integer,Integer> p2=new Pair(point2[0],point1[1]);
                
                if(set.contains(p1)&&set.contains(p2))
                {
                    //System.out.println(point1[0]+" , "+point1[1]+"|"+point2[0]+" , "+point2[1]);
                    ans=Math.min(ans,Math.abs(point1[0]-point2[0])*Math.abs(point1[1]-point2[1]));
                }
            }
        }
        
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}