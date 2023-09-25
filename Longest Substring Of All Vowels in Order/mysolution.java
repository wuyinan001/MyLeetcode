class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int n=word.length();
        
        if(n==0)
            return 0;
        
        int start=0,end=1;
        int ans=0;
        char curr=word.charAt(0);
        
        Set<Character> set=new HashSet();
        set.add(curr);
        
        while(end<n)
        {
            char c=word.charAt(end);
            
            if(c>=curr)
            {
                set.add(c);
                curr=c;
                end++;
                continue;
            }
            else
            {
                if(set.size()==5)
                {
                    ans=Math.max(ans,end-start);
                    
                }
                
                set.clear();
                set.add(c);
                curr=c;
                start=end;
            }
            
            end++;
        }
        
        if(set.size()==5)
        {
            ans=Math.max(ans,end-start);

        }
        
        return ans;
    }
}