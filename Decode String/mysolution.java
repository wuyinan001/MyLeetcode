class Solution {
    public String decodeString(String s) {
        
        Stack<Character> stack=new Stack();
        
        int n=s.length();
        
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            
            if(c==']')
            {
                StringBuilder sb1=new StringBuilder();
                
                while(stack.peek()!='[')
                {
                    sb1.append(stack.pop());
                }
                
                // Remove '['
                stack.pop();
                
                int count=0;
                int carry=1;
                
                while(!stack.isEmpty()&&stack.peek()>='0'&&stack.peek()<='9')
                {
                    count+=(stack.pop()-'0')*carry;
                    carry=carry*10;
                }
                
                String word=sb1.reverse().toString();
                
                StringBuilder sb2=new StringBuilder();
                
                for(int j=1;j<=count;j++)
                    sb2.append(word);
                
                for(int j=0;j<sb2.length();j++)
                    stack.push(sb2.charAt(j));
            }
            else
                stack.push(c);
        }
        
        StringBuilder ans=new StringBuilder();
        
        for(char c:stack)
            ans.append(c);
        
        return ans.toString();
    }
}