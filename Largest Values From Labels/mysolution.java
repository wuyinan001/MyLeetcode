class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        
        int n=values.length;
        
        int count=0, ans=0;
        
        Map<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<n;i++)
            if(!map.containsKey(labels[i]))
                map.put(labels[i],0);
        
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return values[a2]-values[a1];
            }
            
        });
        
        for(int i=0;i<n;i++)
            pq.add(i);
        
        while(!pq.isEmpty())
        {
            int index=pq.poll();
            
            if(count<num_wanted&&map.get(labels[index])<use_limit)
            {
                ans+=values[index];
                count++;
                map.put(labels[index],map.get(labels[index])+1);
            }
        }
        
        return ans;
        
    }
}