class Solution {
    public String smallestSubsequence(String s) {
        
        Set<Character> seen=new HashSet();
        Map<Character,Integer> map=new HashMap();
        
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }
        
        Stack<Character> stack=new Stack();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(!seen.contains(c))
            {
                while(!stack.isEmpty()&&map.get(stack.peek())>i&&c<stack.peek())
                {
                    seen.remove(stack.pop());
                }
                
                stack.push(c);
                seen.add(c);
            }
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(char c:stack)
            sb.append(c);
        
        return sb.toString();
    }
}