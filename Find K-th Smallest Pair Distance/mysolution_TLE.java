class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        int n=nums.length;
        
        Arrays.sort(nums);
        
        // a[]: 0: the i index, 1: the j index, 2: the |ai-aj|
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a2[2]-a1[2];
            }
            
        });
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                pq.add(new int[]{i,j,nums[j]-nums[i]});
                if(pq.size()>k)
                    pq.poll();
            }
        }
        
        return pq.peek()[2];
            
    }
}