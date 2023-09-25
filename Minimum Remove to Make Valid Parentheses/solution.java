class Solution {
    public String minRemoveToMakeValid(String s) {
        
        List<Integer> remove=new ArrayList();
        
        Stack<Integer> stack=new Stack();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c=='(')
                stack.add(i);
            else if(c==')')
            {
                if(stack.isEmpty())
                {
                    remove.add(i);
                }
                else
                {
                    stack.pop();
                }
            }
                
        }
        
        while(!stack.isEmpty())
            remove.add(stack.pop());
        
        
        StringBuilder sb=new StringBuilder();
        
        
        for(int i=0;i<s.length();i++)
        {
            
            if(!remove.contains(i))
            {
                sb.append(s.charAt(i));
            }
                
        }
        
        return sb.toString();
    }

}