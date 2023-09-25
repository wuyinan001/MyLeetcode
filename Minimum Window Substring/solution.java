class Solution {
    public String minWindow(String s, String t) {
        
        if(s==""||t=="")
            return "";
        
        Map<Character,Integer> dict=new HashMap<>();
        
        for(int i=0;i<t.length();i++)
        {
            char c=t.charAt(i);
            dict.put(c,dict.getOrDefault(c,0)+1);
        }
        
        int required=dict.size();
        
        Map<Character,Integer> windowString=new HashMap<>();
        
        int formed=0;
        int l=0,r=0;
        
        int[] ans={-1,l,r};
        
        while(r<s.length())
        {
            char c=s.charAt(r);
            
            windowString.put(c,windowString.getOrDefault(c,0)+1);
            
            if(dict.containsKey(c)&&dict.get(c).intValue()==windowString.get(c).intValue())
                formed++;
            
            while(formed==required&&l<=r)
            {
                if(ans[0]==-1||ans[0]>r-l+1)
                {
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                
                c=s.charAt(l);
                
                windowString.put(c,windowString.get(c)-1);
                
                if(dict.containsKey(c)&&windowString.get(c).intValue()<dict.get(c).intValue())
                    formed--;
                
                l++;
            }
            
            r++;
        }
        
        return ans[0]==-1 ? "" : s.substring(ans[1],ans[2]+1);
    }
}