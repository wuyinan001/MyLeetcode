class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        Map<Character,int[]> map=new HashMap();
        
        int n=s.length();
        
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            
            if(!map.containsKey(c))
            {
                map.put(c,new int[]{i,i});
            }
            else
                map.get(c)[1]=i;
        }
        
        int substringStart=-1;
        
        List<String> ans=new ArrayList();
        
        for(int i=0;i<n;i++)
        {
            int startIndex=map.get(s.charAt(i))[0];
            
            if(startIndex==i)
            {
                int substringEnd=getEnd(s,map,i);
                //System.out.println("i"+i+"substringEnd"+substringEnd);
                
                if(substringEnd!=-1)
                {
                    if(substringEnd>substringStart)
                        ans.add("");
                    
                    ans.set(ans.size()-1,s.substring(i,substringEnd+1));
                    substringStart=substringEnd;
                }
            }

        }
        
        return ans;
    }
    
    
    private int getEnd(String s, Map<Character,int[]> map, int start)
    {
        int end=map.get(s.charAt(start))[1];
        
        for(int i=start+1;i<=end;i++)
        {
            if(map.get(s.charAt(i))[0]<start)
                return -1;
            
            end=Math.max(end,map.get(s.charAt(i))[1]);
        }
        
        return end;
    }
}