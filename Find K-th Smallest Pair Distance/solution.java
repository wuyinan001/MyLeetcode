class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        int n=nums.length;
        Arrays.sort(nums);
        
        int WIDTH=2*nums[n-1];
        int[] multiple=new int[n];
        
        // multiple[i]: 
        for(int i=1;i<n;i++)
            if(nums[i]==nums[i-1])
                multiple[i]=1+multiple[i-1];
        
        // prev[v]: num of nums[v]<=v
        int[] prefix=new int[WIDTH];
        int left=0;
        for(int i=0;i<WIDTH;i++)
        {
            while(left<n&&nums[left]==i)
            {
                left++;
            }
            prefix[i]=left;
        }
        
        int lo=0, hi=nums[n-1]-nums[0];
        int mid=0;
        while(lo<hi)
        {
            mid=lo+(hi-lo)/2;
            int count=0;
            for(int i=0;i<n;i++)
            {
                count+=prefix[nums[i]+mid]-prefix[nums[i]]+multiple[i];
            }
            
            if(count>=k)
                hi=mid;
            else 
                lo=mid+1;
        }
        
        return lo;
    }
}