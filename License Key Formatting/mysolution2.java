class Solution {
    public String licenseKeyFormatting(String s, int k) {
        
        Stack<Character> stack=new Stack();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c!='-')
            {
                if(c>='a'&&c<='z')
                    c=(char)(c-'a'+'A');
                
                stack.push(c);
            }
                
        }
        
        StringBuilder sb=new StringBuilder();
        
        int count=0;
        while(!stack.isEmpty())
        {
            if(count==k)
            {
                sb.append('-');
                count=0;
            }
            
            sb.append(stack.pop());
            count++;
        }
        
        return sb.reverse().toString();
    }
}