class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> stack=new Stack();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c=='#')
            {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(c);
        }
        
        StringBuilder sb1=new StringBuilder();
        
        for(char c:stack)
            sb1.append(c);
        
        stack.clear();
        
        for(int i=0;i<t.length();i++)
        {
            char c=t.charAt(i);
            
            if(c=='#')
            {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(c);
        }
        
        StringBuilder sb2=new StringBuilder();
        
        for(char c:stack)
            sb2.append(c);
        
        return sb1.toString().equals(sb2.toString());
    }
}