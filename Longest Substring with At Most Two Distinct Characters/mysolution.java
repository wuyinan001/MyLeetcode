class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        Map<Character,Integer> map=new HashMap<>();
        
        int start=0,end=0,ans=0;
        
        while(end<s.length())
        {
            char c=s.charAt(end);
            
            map.put(c,map.getOrDefault(c,0)+1);
            
            if(map.size()>2)
                ans=Math.max(ans,end-start);
            
            while(map.size()>2)
            {
                char c2=s.charAt(start);
                
                if(map.get(c2)==1)
                    map.remove(c2);
                else
                    map.put(c2,map.get(c2)-1);
                start++;
            }
            
            end++;
        }
        
        if(map.size()<=2)
            ans=Math.max(ans,end-start);
        
        return ans;
    }
}