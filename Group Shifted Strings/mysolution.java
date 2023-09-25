class Solution {
    
    private boolean isSeq(String s1, String s2)
    {
        if(s1.length()!=s2.length())
            return false;

        
        int diff=s2.charAt(0)-s1.charAt(0);
        
        if(diff<0)
            diff=diff+26;
        
        for(int i=1;i<s1.length();i++)
        {
            if((s1.charAt(i)-'a'+diff)%26!=(s2.charAt(i)-'a'))
                return false;
        }
        
        return true;
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        
        Set<Integer> set=new HashSet();
        int n=strings.length;
        List<List<String>> ans=new ArrayList();
        
        for(int i=0;i<n;i++)
        {
            if(set.contains(i))
                continue;
            
            String s=strings[i];
            set.add(i);
            List<String> list=new ArrayList();
            list.add(s);
            
            for(int j=i+1;j<n;j++)
            {
                if(!set.contains(j)&&isSeq(s,strings[j]))
                {
                    list.add(strings[j]);
                    set.add(j);
                }
            }
            
            ans.add(list);
        }
        
        return ans;
    }
}