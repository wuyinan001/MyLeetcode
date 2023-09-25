class Solution {
    public int maxProduct(int[] nums) {
        
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        // max_so_far[i]: the max product of subarray of nums ending at i;
        // min_so_far[i]: the min product of subarray of nums ending at i;
        
        // When nums[i]>=0: 
        //  max_so_far[i]=Math.max(max_so_far[i-1]*nums[i],nums[i]);
        //  min_so_far[i]=Math.min(min_so_far[i-1]*nums[i],nums[i]);
        // When nums[i]<0: 
        //  max_so_far[i]=Math.max(min_so_far[i-1]*nums[i],nums[i]);
        //  min_so_far[i]=Math.min(max_so_far[i-1]*nums[i],nums[i]);
        
        int[] max_so_far=new int[n];
        int[] min_so_far=new int[n];
        
        max_so_far[0]=nums[0];
        min_so_far[0]=nums[0];
        
        int max=nums[0];
        
        for(int i=1;i<n;i++)
        {
            if(nums[i]>=0)
            {
                max_so_far[i]=Math.max(max_so_far[i-1]*nums[i],nums[i]);
                min_so_far[i]=Math.min(min_so_far[i-1]*nums[i],nums[i]);
            }
            else
            {
                max_so_far[i]=Math.max(min_so_far[i-1]*nums[i],nums[i]);
                min_so_far[i]=Math.min(max_so_far[i-1]*nums[i],nums[i]);
            }
            
            if(max<max_so_far[i])
                max=max_so_far[i];
            
        }
        
        //print(max_so_far);
        
        return max;
    }
    
    private void print(int[] L)
    {
        int n=L.length;
        
        for(int i=0;i<n;i++)
        {
            System.out.print(L[i]+" ");
        }
        
        System.out.println();
    }
}