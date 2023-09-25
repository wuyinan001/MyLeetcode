class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        
        Map<Integer,Double> map=new HashMap();
        int n=quality.length;
        
        for(int i=0;i<n;i++)
            map.put(i,(double)(wage[i])/quality[i]);
        
        /*
        for(int i=0;i<n;i++)
            System.out.println(map.get(i));*/
        
        List<Integer> list=new ArrayList(map.keySet());
        
        // Sort map key by wage/quality ratio
        Collections.sort(list,new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                if(map.get(a1)<map.get(a2))
                    return -1;
                else if(map.get(a1)>map.get(a2))
                    return 1;
                else 
                    return 0;
                
            }
            
        });
        
        // ans stores the min total wage
        double ans=Double.MAX_VALUE;
        // sum stores the cumulative qualities of workers selected
        int sum=0;
        
        // Max heap using quality for comparison
        PriorityQueue<Integer> pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return quality[a2]-quality[a1];
            }
            
        });
        
        for(int i:list)
        {
            sum=sum+quality[i];
            pq.add(i);
			
            // At the same wage/quality ratio, the highest quality worker needs highest wage. So if the num of workers exceeds K, remove the
            // the highest quality worker first
            if(pq.size()>K)
                sum=sum-quality[pq.poll()];
            
            if(pq.size()==K)
            {
                //System.out.println("i: sum "+sum+"ratio "+map.get(i));
                ans=Math.min(ans,sum*map.get(i));
            }
                
        }
        
        return ans;
    }
}