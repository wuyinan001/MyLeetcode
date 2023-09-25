class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        
        for(int i=0;i<n;i++)
            map.put(i,arr[i]);
        
        List<Map.Entry<Integer,Integer>> list=new ArrayList(map.entrySet());
        
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            
            public int compare(Map.Entry<Integer,Integer> m1, Map.Entry<Integer,Integer> m2)
            {
                return m1.getValue()-m2.getValue();
            }
        });
        
        int[] rank=new int[n];
        
        if(n==0)
            return rank;
        
        rank[list.get(0).getKey()]=1;
        int curr_rank=1;
        
        for(int i=1;i<n;i++)
        {
            if(list.get(i).getValue()>list.get(i-1).getValue())
                curr_rank++;
            
            rank[list.get(i).getKey()]=curr_rank;
        }
        
        return rank;
    }
}