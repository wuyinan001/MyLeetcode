class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int index=0;
        Deque<Integer> dq=new ArrayDeque<Integer>();
        
        for(int i=0;i<n;i++)
        {
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i])
                dq.pollLast();
            
            if(!dq.isEmpty()&&dq.peekFirst()<=i-k)
                dq.pollFirst();
            
            dq.offerLast(i);
            
            if(i>=k-1)
                ans[index++]=nums[dq.peekFirst()];
        }
        
        return ans;
    }
}