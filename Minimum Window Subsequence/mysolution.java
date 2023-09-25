class Solution {
    public String minWindow(String S, String T) {
        
        int n=S.length();
        
        int start=0, end=0, len=n;
        String ans="";
        
        int t_index=0;
        
        while(end<n)
        {
            char c=S.charAt(end);
            
            if(c==T.charAt(t_index))
            {
                if(t_index==T.length()-1)
                {
                    if(len>end-start+1)
                    {
                        ans=S.substring(start,end+1);
                        len=end-start+1;
                    }
                    
                    // When t_index==T.length()-1, the string starts at start and ends at end contains T
                    // The next step is try to find a smaller string. The new start index starts at "old_start+1" and the end index
                    // also starts at "old_start+1". However, at the end of the loop there is "end++", therefore set new end to be "old_start"
                    start=start+1;
                    end=start-1;
                    t_index=0;
                }
                else
                    t_index++;
            }
            else if(t_index==0)
                start++;
            
            end++;
        }
        
        return ans;
    }
}