class Solution {
    public String simplifyPath(String path) {
        
        String[] dirs=path.split("/");
        Stack<String> stack=new Stack();
        
        for(String dir:dirs)
        {
            if(dir.isEmpty()||dir.equals("."))
                continue;
            else if(dir.equals(".."))
            {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.add(dir);
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(String s:stack)
        {
            sb.append("/");
            sb.append(s);
        }
            
        if(sb.length()==0)
            return "/";
        else
            return sb.toString();
    }
}