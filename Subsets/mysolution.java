class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        ans.add(new ArrayList<Integer>());
        
        backTrack(ans,nums,0);
        
        return ans;
    }
    
    private void backTrack(List<List<Integer>> ans, int[] nums, int index)
    {
        if(index>=nums.length)
            return;
        
        int length=ans.size();
        
        for(int i=0;i<length;i++)
        {
            List<Integer> l=new ArrayList<>(ans.get(i));
            l.add(nums[index]);
            ans.add(l);
        }
        
        backTrack(ans,nums,index+1);
    }
    
    
}