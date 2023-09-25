class Solution {
    
    int ans=0;
    
    private boolean overlap(StringBuilder sb, String s)
    {
        for(int i=0;i<sb.length();i++)
            for(int j=0;j<s.length();j++)
                if(sb.charAt(i)==s.charAt(j))
                    return true;
        
        return false;
    }
    
    private boolean unique(String s)
    {
        if(s.length()>26)
            return false;
        
        Set<Character> set=new HashSet();
        
        for(int i=0;i<s.length();i++)
            set.add(s.charAt(i));
        
        return set.size()==s.length();
    }
    
    private void backTrack(List<String> arr, int index, StringBuilder sb)
    {
        if(index==arr.size())
        {
            ans=Math.max(ans,sb.length());
            return;
        }
        
        if(!overlap(sb,arr.get(index))&&unique(arr.get(index)))
        {
            int l=arr.get(index).length();
            backTrack(arr,index+1,sb.append(arr.get(index)));
            sb.delete(sb.length()-l,sb.length());
        }
        
        backTrack(arr,index+1,sb);
    }
    
    public int maxLength(List<String> arr) {
        
        backTrack(arr,0,new StringBuilder());
        
        return ans;
    }
}