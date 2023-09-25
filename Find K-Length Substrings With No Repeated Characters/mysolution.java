class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        
        Map<Character,Integer> map=new HashMap();
        
        int n=s.length();
        
        if(n<k)
            return 0;
        
        int end=0, start=0, ans=0;
        
        while(end<n)
        {
            char c=s.charAt(end);
            
            map.put(c,map.getOrDefault(c,0)+1);
            
            if(end-start==k-1)
            {
                if(map.size()==k)
                    ans++;
                
                char c1=s.charAt(start++);
                if(map.get(c1)>1)
                    map.put(c1,map.get(c1)-1);
                else
                    map.remove(c1);
                
            }
            
            end++;
        }
        
        
        
        return ans;
        
    }
}