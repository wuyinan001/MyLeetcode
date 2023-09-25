class Solution {
    
    int n;
    
    private boolean isSquare(String word, LinkedList<String> list, int index)
    {
        StringBuilder sb=new StringBuilder();
        for(String s:list)
            sb.append(s.charAt(index));
        
        return sb.toString().equals(word.substring(0,index));
    }
    
    private void backTrack(List<List<String>> ans, LinkedList<String> list, String[] words, int rows)
    {
        if(list.size()==rows)
        {
            ans.add(new ArrayList(list));
            return;
        }
        
        for(int i=0;i<n;i++)
        {
            if(list.isEmpty()||isSquare(words[i],list,list.size()))
            {
                list.add(words[i]);
                backTrack(ans,list,words,rows);
                list.removeLast();
            }
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        
        n=words.length;
        int len=words[0].length();
        List<List<String>> ans=new ArrayList();
        
        backTrack(ans,new LinkedList(),words,len);
        
        return ans;
    }
}