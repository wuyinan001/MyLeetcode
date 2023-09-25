class Solution {
    
    int ans=0;
    
    private void backTrack(int[] nums, int target)
    {
        for(int i=0;i<nums.length;i++)
        {
            if(target==0)
            {
                ans++;
                return;
            }
            
            if(target<nums[i])
                return;
            
            backTrack(nums,target-nums[i]);
        }
    }
    
    public int combinationSum4(int[] nums, int target) {
        
        Arrays.sort(nums);
        backTrack(nums,target);
        
        return ans;
    }
}