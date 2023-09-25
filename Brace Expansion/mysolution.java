class Solution {
    
    private List<String> expandList(String s)
    {
        List<String> ans=new ArrayList();
        
        if(s.equals(""))
        {
            ans.add("");
            return ans;
        }
        
        if(s.charAt(0)!='{')
        {
            List<String> list=expandList(s.substring(1));
            for(String str:list)
            {
                ans.add(s.charAt(0)+str);
            }
        }
        else
        {
            List<String> options=new ArrayList();
            int i=1;
            
            while(i<s.length())
            {
                if(s.charAt(i)=='}')
                    break;
                
                if(s.charAt(i)!=',')
                    options.add(s.charAt(i)+"");
                
                i++;
            }
            
            List<String> list=expandList(s.substring(i+1));
            
            for(String s1:options)
            {
                for(String s2:list)
                {
                    ans.add(s1+s2);
                }
            }
        }
        
        return ans;
            
    }
    
    public String[] expand(String s) {
        
        List<String> list=expandList(s);
        
        Collections.sort(list,new Comparator<String>(){
            
            public int compare(String s1,String s2)
            {
                return s1.compareTo(s2);
            }
            
        });
        
        String[] ans=new String[list.size()];
        
        for(int i=0;i<ans.length;i++)
            ans[i]=list.get(i);
        
        return ans;
    }
}