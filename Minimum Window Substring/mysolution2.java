class Solution {
    public String minWindow(String s, String t) {
     
        if(s.equals("")||t.equals(""))
            return "";
        
        Map<Character,Integer> dict=new HashMap<>();
        Map<Character,Integer> word=new HashMap<>();
        int formed=0;
        int[] ans={0,0,-1};
        
        for(int i=0;i<t.length();i++)
        {
            char c=t.charAt(i);
            dict.put(c,dict.getOrDefault(c,0)+1);
        }
        
        int required=dict.size();
        
        int l=0,r=0;
        
        while(r<s.length())
        {
            char c=s.charAt(r);
            word.put(c,word.getOrDefault(c,0)+1);

            if(dict.containsKey(c)&&dict.get(c).intValue()==word.get(c).intValue())
            {
                formed++;
            }
                

            while(formed==dict.size()&&l<=r)
            {
                
                c=s.charAt(l);
                
                if(dict.containsKey(c)&&dict.get(c).intValue()==word.get(c).intValue())
                {
                    formed--;
                    if(ans[2]==-1||ans[2]>r-l+1)
                    {
                        ans[0]=l;
                        ans[1]=r;
                        ans[2]=r-l+1;
                    }
                }
                
                l++;
                word.put(c,word.get(c).intValue()-1);
            }
            
            
            r++;
        }
        
        return ans[2]==-1 ? "" : s.substring(ans[0],ans[1]+1);
    }
}