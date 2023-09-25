class Solution {
    public String removeDuplicateLetters(String s) {
        
        int n=s.length();
        Stack<Character> stack=new Stack();
        Set<Character> set=new HashSet();
        
        // Map contains the last occurance of char c in s
        Map<Character,Integer> map=new HashMap();
        
        for(int i=0;i<n;i++)
        {
            map.put(s.charAt(i),i);
        }
            
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            
            if(!set.contains(c))
            {
                while(!stack.isEmpty()&&stack.peek()>c&&map.get(stack.peek())>i)
                {
                    char temp=stack.pop();
                    set.remove(temp);
                    
                }
                
                stack.push(c);
                set.add(c);
            }
            
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(Character c:stack)
            sb.append(c);
        
        return sb.toString();
    }
}