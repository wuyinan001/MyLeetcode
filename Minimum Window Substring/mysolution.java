class Solution {
    public String minWindow(String s, String t) {
     
        if(s.equals("")||t.equals(""))
            return "";
        
        Map<Character,Integer> dict=new HashMap<>();
        Map<Character,Integer> curr=new HashMap<>();
        
        for(int i=0;i<t.length();i++)
        {
            char c=t.charAt(i);
            dict.put(c,dict.getOrDefault(c,0)+1);
        }
        
        int required=dict.size();
        int formed=0;
        
        int[] ans=new int[]{-1,0,0};
        
        int l=0,r=0;
        
        while(r<s.length())
        {
            char c=s.charAt(r);
            
            curr.put(c,curr.getOrDefault(c,0)+1);
            
            if(dict.containsKey(c)&&curr.get(c).intValue()==dict.get(c).intValue())
                formed++;
            
            while(formed==required&&l<=r)
            {
                if(ans[0]==-1||ans[0]>r-l+1)
                {
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                
                c=s.charAt(l++);
                curr.put(c,curr.getOrDefault(c,0)-1);
                
                if(dict.containsKey(c)&&curr.get(c).intValue()<dict.get(c).intValue())
                {
                    formed--;
                    break;
                }

            }
            
            r++;
        }
        
        
        if(ans[0]==-1)
            return "";
        else
            return s.substring(ans[1],ans[2]+1);
    }
}