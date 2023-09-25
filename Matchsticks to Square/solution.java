class Solution {
    
    int n,sum=0;
    
    // Find if it possible to partition nums array into K parts with equal sum
    
    private boolean backTrack(int[] nums,boolean[] visited, int target, int currSum, int start_index, int k)
    {
        if(k==1)
            return true;
        
        if(currSum==target)
            return backTrack(nums,visited,target,0,0,k-1);
        
        for(int i=start_index;i<n;i++)
        {
            if(visited[i]||nums[i]+currSum>target)
                continue;
            
            visited[i]=true;
            
            if(backTrack(nums,visited,target,currSum+nums[i],i+1,k))
                return true;
            
            visited[i]=false;
        }
        
        return false;
    }
    
    public boolean makesquare(int[] matchsticks) {
        
        n=matchsticks.length;
        
        for(int i:matchsticks)
            sum+=i;
        
        if(sum%4!=0)
            return false;
        
        int width=sum/4;
        
        boolean[] visited=new boolean[n];
        
        return backTrack(matchsticks,visited,width,0,0,4);
    
    }
}