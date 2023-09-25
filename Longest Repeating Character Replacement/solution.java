class Solution {
    
    public int characterReplacement(String s, int k) {
        
        
        int ans=0;
        int left=0,right=0;
        int maxFreq=0;
        Map<Character,Integer> map=new HashMap<>();
        
        for(right=0;right<s.length();right++)
        {
            char right_char=s.charAt(right);
            
            map.put(right_char,map.getOrDefault(right_char,0)+1);
            
            maxFreq=Math.max(maxFreq,map.get(right_char));
            
            if(right-left+1-maxFreq>k)
            {
                char left_char=s.charAt(left);
                map.put(left_char,map.getOrDefault(left_char,0)-1);
                left++;
            }
            
            ans=Math.max(ans,right-left+1);
        }
        
        return ans;
    }
}