class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people,new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                if(a1[0]==a2[0])
                    return a1[1]-a2[1];
                return a2[0]-a1[0];
            }
            
        });
        
        List<int[]> list=new ArrayList();
        
        for(int[] p:people)
        {
            list.add(p[1],p);
        }
        
        return list.toArray(new int[list.size()][]);
    }
}