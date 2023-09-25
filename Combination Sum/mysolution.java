class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        
        backTrack(ans,list,candidates,0,target);
        
        return ans;
        
    }
    
    private void backTrack(List<List<Integer>> ans, List<Integer> list, int[] candidates, int start, int target)
    {
        if(target==0)
        {
            ans.add(list);
            return;
        }
        
        for(int i=start;i<candidates.length;i++)
        {
            if(candidates[i]<=target)
            {
                List<Integer> temp=new ArrayList(list);
                temp.add(candidates[i]);
                backTrack(ans,temp,candidates,i,target-candidates[i]);
            }
        }
    }
    

}