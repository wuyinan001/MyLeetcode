class Solution {
    public boolean isValid(String s) {
        
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            
            if(c=='('||c=='['||c=='{')
            {
                stack.push(c);
                continue;
            }
            
            if(stack.isEmpty())
                return false;
                
            if(c==')'&&stack.peek()=='(')
            {
                stack.pop();
                continue;
            }
            
            if(c==']'&&stack.peek()=='[')
            {
                stack.pop();
                continue;
            }
            
            if(c=='}'&&stack.peek()=='{')
            {
                stack.pop();
                continue;
            }
            
            return false;
            
        }
        
        return stack.isEmpty();
    }
}