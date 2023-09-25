class Solution {
    
    int n;
    
    private void backTrack(int[] candidates, int index, int target, List<Integer> list1, Set<List<Integer>> list2)
    {
        if(target==0)
        {
            list2.add(list1);
            return;
        }
        
        if(index==n)
            return;
        
        backTrack(candidates,index+1,target,list1,list2);
        
        if(candidates[index]<=target)
        {
            List<Integer> newList=new ArrayList(list1);
            newList.add(candidates[index]);
            backTrack(candidates,index+1,target-candidates[index],newList,list2);
        }
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        n=candidates.length;
        
        Arrays.sort(candidates);
        
        Set<List<Integer>> set=new HashSet();
        List<List<Integer>> ans=new ArrayList();
        
        backTrack(candidates,0,target,new ArrayList(),set);
        
        for(List<Integer> l:set)
            ans.add(l);
        
        return ans;
    }
}