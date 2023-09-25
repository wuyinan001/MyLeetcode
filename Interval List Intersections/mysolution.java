class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> list=new ArrayList();
        
        for(int[] interval:firstList)
        {
            list.add(interval);
        }
        
        for(int[] interval:secondList)
        {
            list.add(interval);
        }
        
        Collections.sort(list,new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                if(a1[0]==a2[0])
                    return a1[1]-a2[1];
                return a1[0]-a2[0];
            }
            
        });
        
        List<int[]> ans=new ArrayList();
        
        for(int i=0;i<list.size()-1;i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                int[] a1=list.get(i), a2=list.get(j);
            
                if(a1[1]>=a2[0])
                    ans.add(new int[]{a2[0],Math.min(a1[1],a2[1])});
            }
            
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}