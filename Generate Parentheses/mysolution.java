class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans=new ArrayList<>();
        
        backTrack(ans,"",0,0,n);
        
        return ans;
        
    }
    
    private void backTrack(List<String> ans,String curr,int open, int close, int max)
    {
        if(curr.length()==max*2)
        {
            ans.add(curr);
            return;
        }
        
        if(open<max)
        {
            backTrack(ans,curr+"(",open+1,close,max);
        }
        
        if(close<open)
        {
            backTrack(ans,curr+")",open,close+1,max);
        }
    }
}