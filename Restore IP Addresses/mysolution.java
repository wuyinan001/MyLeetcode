class Solution {
    public List<String> restoreIpAddresses(String s) {
     
        List<String> ans=new ArrayList<>();
        
        if(s.length()<4)
            return ans;
        
        backTrack(ans,"",s,0,4);
        
        return ans;
    }
    
    private void backTrack(List<String> ans, String curr, String s, int start, int remaining)
    {
        if(remaining==0)
        {
            if(curr.length()==s.length()+3)
                ans.add(curr);
            return;
        }
        
        // Adding next 1 digit to next ip addr section
        if(start<s.length()&&Integer.parseInt(s.substring(start,start+1))<=255)
        {
            if(remaining==1)
                backTrack(ans,curr+s.substring(start,start+1),s,start+1,remaining-1);
            else
                backTrack(ans,curr+s.substring(start,start+1)+".",s,start+1,remaining-1);
        }
            
        // Adding next 2 digit to next ip addr section
        if(start+1<s.length()&&s.charAt(start)!='0'&&Integer.parseInt(s.substring(start,start+2))<=255)
        {
            if(remaining==1)
                backTrack(ans,curr+s.substring(start,start+2),s,start+2,remaining-1);
            else
                backTrack(ans,curr+s.substring(start,start+2)+".",s,start+2,remaining-1);
        }
        
        // Adding next 3 digit to next ip addr section
        if(start+2<s.length()&&s.charAt(start)!='0'&&Integer.parseInt(s.substring(start,start+3))<=255)
        {
            if(remaining==1)
                backTrack(ans,curr+s.substring(start,start+3),s,start+3,remaining-1);
            else
                backTrack(ans,curr+s.substring(start,start+3)+".",s,start+3,remaining-1);
        }
    }
}