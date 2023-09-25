class Solution {
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int start=0,end=0;
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        
        while(end<s.length())
        {
            char c=s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            
            if(map.size()>k)
                ans=Math.max(ans,end-start);
                
            while(map.size()>k)
            {
                c=s.charAt(start);
                if(map.get(c)==1)
                    map.remove(c);
                else
                    map.put(c,map.get(c)-1);
                start++;
            }
                
            
            end++;
        }
        
        if(map.size()<=k)
            ans=Math.max(ans,end-start);
        
        return ans;
    }
}