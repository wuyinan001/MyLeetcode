class Solution {
    
    private void backTrack(List<List<Integer>> ans, LinkedList<Integer> list, int[] nums, int index, int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList(list));
            return;
        }
        
        for(int i=index;i<nums.length;i++)
        {
            // To make sure the first element in each combination is different
            if(i>index&&nums[i]==nums[i-1])
                continue;
            
            if(nums[i]>target)
                break;
            
            list.add(nums[i]);
            backTrack(ans,list,nums,i+1,target-nums[i]);
            list.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList();
        
        backTrack(ans,new LinkedList(),candidates,0,target);
        
        return ans;
    }
}