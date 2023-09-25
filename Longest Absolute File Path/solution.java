class Solution {
    
    // Count how many c at the head of s
    private int count(String s, char c)
    {
        int ans=0;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=c)
                return ans;
            
            ans++;
        }
        
        return ans;
    }
    
    // Check if string s contains char c or not
    private boolean contains(String s, char c)
    {
        for(int i=s.length()-1;i>=0;i--)
            if(s.charAt(i)==c)
                return true;
        
        return  false;
    }
    
    public int lengthLongestPath(String input) {
        
        String[] words=input.split("\n");
        
        int curr=0, ans=0;
        
        Stack<String> stack=new Stack();
        
        for(String word:words)
        {
            int num=count(word,'\t');
            
            while(stack.size()>num)
            {
                String last=stack.pop();
                // +1 append '/'
                curr=curr-(last.length()+1);
            }
            
            word=word.substring(num);
            
            // +1 append '/'
            curr=curr+(word.length()+1);
            stack.push(word);
            
            if(contains(word,'.'))
            {
                // curr-1 because need remove the last '/'
                ans=Math.max(ans,curr-1);
            }
        }
        
        return ans;
        
    }
}