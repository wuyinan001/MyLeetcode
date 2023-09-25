class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        Map<Integer,Integer> map=new HashMap();
        
        int count=0;
        
        for(int i:arr2)
            map.put(i,count++);
            
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                if(map.containsKey(a1)&&map.containsKey(a2))
                    return map.get(a1)-map.get(a2);
                else if(map.containsKey(a1))
                    return -1;
                else if(map.containsKey(a2))
                    return 1;
                else
                    return a1-a2;
            }
            
        });
        
        for(int i:arr1)
            pq.add(i);
        
        int[] result=new int[arr1.length];
        
        for(int i=0;i<arr1.length;i++)
            result[i]=pq.poll();
        
        return result;
    }
}