class Solution {
    
    private void backTrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index, int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList(curr));
            return;
        }
        
        for(int i=index;i<nums.length;i++)
        {
            if(nums[i]>target)
                continue;
            
            curr.add(nums[i]);
            backTrack(ans,curr,nums, i, target-nums[i]);
            curr.remove(curr.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans=new ArrayList();
        
        backTrack(ans,new ArrayList(),candidates, 0, target);
        
        return ans;
    }
}