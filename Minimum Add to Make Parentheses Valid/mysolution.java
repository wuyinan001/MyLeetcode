class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> stack=new Stack();
        int n=s.length();
        
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            
            if(c==')')
            {
                if(!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
                else
                    stack.push(c);
            }
            else
                stack.push(c);
        }
        
        return stack.size();
    }
}