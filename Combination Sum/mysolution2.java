class Solution {
    
    int n;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans=new ArrayList();
        n=candidates.length;
        
        backTrack(candidates,0,target,new ArrayList(),ans);
        
        return ans;
    }
    
    private void backTrack(int[] candidates, int start, int target, List<Integer> list1, List<List<Integer>> list2)
    {
        if(target==0)
        {
            list2.add(list1);
            return;
        }
        
        if(start==n)
            return;
        
        
        backTrack(candidates,start+1,target,list1,list2);
            
        if(candidates[start]<=target)
        {
            List<Integer> newList=new ArrayList(list1);
            newList.add(candidates[start]);
            backTrack(candidates,start,target-candidates[start],newList,list2);
        }
        
    }
}