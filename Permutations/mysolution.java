class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans=new LinkedList<>();
        
        backTrack(ans,nums,0);
        
        return ans;
    }
    
    // In general, for every existing list of size n, there will be n+1 new lists created after a new element
    // is inserted and the new element will be inserted at index 0,1,2,3,...,n
    private void backTrack(List<List<Integer>> ans, int[] nums, int index)
    {
        if(index>=nums.length)
            return;
        
        if(index==0)
        {
            List<Integer> list=new ArrayList<>();
            list.add(nums[0]);
            ans.add(list);
            backTrack(ans,nums,index+1);
            
            return;
        }
        
        int length=ans.size();
        
        for(int i=0;i<length;i++)
        {
            int n=ans.get(i).size();
            
            for(int j=0;j<n;j++)
            {
                List<Integer> list=new ArrayList(ans.get(i));
                list.add(j,nums[index]);
                ans.add(list);
            }
            
            ans.get(i).add(nums[index]);
        }
        
        backTrack(ans,nums,index+1);
    }
}