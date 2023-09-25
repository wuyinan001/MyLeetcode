class Solution {
    
    int n;
    
    private void backTrack(int[] nums, List<List<Integer>> ans, List<Integer> list)
    {
        if(list.size()==n)
        {
            ans.add(list);
        }
            
        for(int i=0;i<n;i++)
        {
            if(!list.contains(nums[i]))
            {
                List<Integer> newList=new ArrayList(list);
                newList.add(nums[i]);
                backTrack(nums,ans,newList);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        n=nums.length;
        
        List<List<Integer>> ans=new ArrayList();
        
        backTrack(nums,ans,new ArrayList());
        
        return ans;
    }
}