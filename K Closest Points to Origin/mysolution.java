class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        Map<int[],Integer> map=new HashMap<>();
        
        for(int i=0;i<points.length;i++)
            map.put(points[i],points[i][0]*points[i][0]+points[i][1]*points[i][1]);
        
        List<Map.Entry<int[],Integer>> list=new ArrayList<>(map.entrySet());
        
        Collections.sort(list,new Comparator<Map.Entry<int[],Integer>>(){
            public int compare(Map.Entry<int[],Integer> o1,Map.Entry<int[],Integer> o2)
            {
                return o1.getValue()-o2.getValue();
            }
        });
        
        int[][] ans=new int[K][2];
        int count=0;
        for(Map.Entry<int[],Integer> l:list)
        {
            ans[count++]=l.getKey();
            if(count==K)
                break;
        }
        
        return ans;
    }
}