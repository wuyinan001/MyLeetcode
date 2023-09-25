class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n1=s1.length(), n2=s2.length();
        
        if(n1>n2)
            return false;
        
        int[] freq=new int[26];
        
        for(int i=0;i<n1;i++)
            freq[s1.charAt(i)-'a']++;
        
        int end=0,start=0,meet=0;
        
        while(end<n2)
        {
            char c=s2.charAt(end);
            
            if(freq[c-'a']>0)
            {
                meet++;
            }
            
            freq[c-'a']--;
            
            if(end-start==n1)
            {
                char c2=s2.charAt(start++);
                if(freq[c2-'a']>=0)
                {
                    meet--;
                }
                
                freq[c2-'a']++;
            }
            
            if(meet==n1)
                return true;
            
            end++;
        }
            
        return false;
    }
}