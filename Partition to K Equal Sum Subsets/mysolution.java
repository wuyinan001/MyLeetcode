class Solution {
    
    private boolean backTrack(int[] nums, boolean[] visited, int target, int curr_sum, int start_index, int k)
    {
        if(k==1)
            return true;
        
        if(curr_sum==target)
            return backTrack(nums,visited,target,0,0,k-1);
        
        for(int i=start_index;i<nums.length;i++)
        {
            // If curr_sum+nums[i]>target, we cannot include nums[i] in curr_sum in this round
            // We may use nums[i] in other rounds
            
            if(visited[i]||curr_sum+nums[i]>target)
                continue;
            
            visited[i]=true;
            
            if(backTrack(nums,visited,target,curr_sum+nums[i],i+1,k))
                return true;
            
            visited[i]=false;
        }
        
        return false;
    }
    
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum=0, n=nums.length;
        
        for(int i:nums)
            sum+=i;
        
        if(sum%k!=0||n<k)
            return false;
        
        int target=sum/k;
        
        boolean[] visited=new boolean[n];
        
        return  backTrack(nums,visited,target,0,0,k);
        
    }
}