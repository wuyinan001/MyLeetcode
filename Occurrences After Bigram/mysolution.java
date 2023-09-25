class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        
        String[] text_str=text.split(" ");
        
        List<String> queue=new ArrayList();
        
        List<String> ans=new ArrayList();
        
        if(text_str.length<3)
            return ans.toArray(new String[ans.size()]);
        
        for(int i=0;i<text_str.length;i++)
        {
            queue.add(text_str[i]);
            
            if(queue.size()>3)
                queue.remove(0);
            
            if(queue.size()==3)
            {
                if(queue.get(0).equals(first)&&queue.get(1).equals(second))
                    ans.add(text_str[i]);
            }
        }
        
        return ans.toArray(new String[ans.size()]);
    }
}