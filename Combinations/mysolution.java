class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        
        backTrack(ans,list,1,n,k);
    
        return ans;
    }
    
    private void backTrack(List<List<Integer>> ans, List<Integer> list, int start, int end, int k)
    {
        if(list.size()==k)
        {
            ans.add(list);
            return;
        }
        
        for(int i=start;i<=end;i++)
        {
            List<Integer> temp=new ArrayList<>(list);
            temp.add(i);
            backTrack(ans,temp,i+1,end,k);
        }
    }
}