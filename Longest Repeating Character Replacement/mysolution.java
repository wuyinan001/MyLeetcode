class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character,Integer> map=new HashMap();
        
        int n=s.length();
        
        int start=0,end=0,ans=0;
        
        // major: the highest frequency so far
        int major=0;
        
        // If the actual max freq is smaller than major in a given range, that is fine
        // because it doesn't affect the final answer.
        // For example, ABAABCDEFGHIJK. k=1
        // At index 3, the major is updated to 3 and it will be always 3 after that
        // In this case, ans=4. Because when end-start+1>=5, end-start+1-major>k.
        
        while(end<n)
        {
            char c=s.charAt(end);
 
            map.put(c,map.getOrDefault(c,0)+1);
            
            if(map.get(c)>major)
            {
                major=map.get(c);
            }
            
            System.out.println(c+" "+major);
            
            if(end-start+1-major>k)
            {
                ans=Math.max(ans,end-start);
                
                char c2=s.charAt(start++);
                if(map.get(c2)==1)
                    map.remove(c2);
                else
                    map.put(c2,map.get(c2)-1);       
            }
            
            end++;
        }
        
        if(end-start-major<=k)
            ans=Math.max(ans,end-start);
        
        return ans;
    }
}