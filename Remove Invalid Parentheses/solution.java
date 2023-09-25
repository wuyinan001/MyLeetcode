class Solution {
    
    Set<String> set=new HashSet();
    int minimumRemoved=Integer.MAX_VALUE;
    
    private void backTrack(String s, int index, int leftcount, int rightcount, int removed, StringBuilder expression)
    {
        if(index==s.length())
        {
            if(leftcount==rightcount)
            {
                if(removed<=minimumRemoved)
                {
                    String str=expression.toString();
                    
                    if(removed<minimumRemoved)
                    {
                        set.clear();
                        minimumRemoved=removed;
                    }
                    
                    set.add(str);
                }
                
            }
        }
        else
        {
            char c=s.charAt(index);
            int length=expression.length();
            
            if(c!='('&&c!=')')
            {
                expression.append(c);
                backTrack(s,index+1,leftcount,rightcount,removed,expression);
                expression.deleteCharAt(length);
            }
            else
            {
                // If current c is '(' or ')', we can choose keep it or delete it
                
                // Option 1: Delete
                backTrack(s,index+1,leftcount,rightcount,removed+1,expression);
                
                // Option 2: Keep
                
                if(c=='(')
                {
                    expression.append(c);
                    backTrack(s,index+1,leftcount+1,rightcount,removed,expression);
                    expression.deleteCharAt(length);
                }
                else if(rightcount<leftcount)
                {
                    expression.append(c);
                    backTrack(s,index+1,leftcount,rightcount+1,removed,expression);
                    expression.deleteCharAt(length);
                }
            }
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        
        backTrack(s,0,0,0,0,new StringBuilder());
        
        List<String> ans=new ArrayList();
        
        for(String str:set)
            ans.add(str);
        
        return ans;
    }
}