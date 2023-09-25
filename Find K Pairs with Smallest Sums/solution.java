class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        int n1=nums1.length, n2=nums2.length;
        
        
        // int[] a with size 3: a[0]: nums1 val, a[1]: nums2 val, a[2]: nums2 index
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a1[0]+a1[1]-a2[0]-a2[1];
            }
            
        });
        
        for(int i=0;i<Math.min(n1,k);i++)
            pq.add(new int[]{nums1[i],nums2[0],0});
        
        List<List<Integer>> ans=new ArrayList();
        
        while(!pq.isEmpty()&&k>0)
        {
            int[] temp=pq.poll();
            
            List<Integer> list=new ArrayList();
            list.add(temp[0]);
            list.add(temp[1]);
            ans.add(list);
            k--;
            
            if(temp[2]+1<n2)
                pq.add(new int[]{temp[0],nums2[temp[2]+1],temp[2]+1});
        }
        
        return ans;
    }
}