class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.equals(""))
            return 0;
        
        Map<Character,Integer> map=new HashMap<>();
        
        int ans=0;
        
        int l=0,r=0;
        
        while(r<s.length())
        {
            char c=s.charAt(r);
            
            map.put(c,map.getOrDefault(c,0)+1);
            
            ans=Math.max(ans,map.size());
            // when repeating chars detected 
            if(map.size()<r-l+1)
            {   
                while(map.size()<r-l+1&&l<=r)
                {
                    c=s.charAt(l);
            
                    if(map.get(c)==1)
                        map.remove(c);
                    else
                        map.put(c,map.get(c)-1);
                    
                    l++;
                }
            }
            
            r++;
        }
        
        return ans;
    }
}