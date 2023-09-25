class Solution {
    
    private List<Character> copy(List<Character> list, int k)
    {
        int n=list.size();
        
        while(k>1)
        {
            for(int i=0;i<n;i++)
                list.add(list.get(i));
            k--;
        }
        
        return list;
    }
    
    public String decodeString(String s) {
        
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        
        Stack<Character> stack=new Stack();
        
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            
            //System.out.println(c);
            
            if(c==']')
            {
                List<Character> list=new ArrayList();
                while(stack.peek()!='[')
                {
                    list.add(stack.pop());
                }
                
                // pop '['
                stack.pop();
                
                int k=0, base=1;
                
                while(!stack.isEmpty()&&stack.peek()>='0'&&stack.peek()<='9')
                {
                    k=k+(stack.pop()-'0')*base;
                    base=base*10;
                }
                
                list=copy(list,k);
                
                for(int j=list.size()-1;j>=0;j--)
                    stack.push(list.get(j));
                
            }
            else
                stack.push(c);
        }
        
        while(!stack.isEmpty())
            sb.insert(0,stack.pop());
        
        return sb.toString();
    }
}