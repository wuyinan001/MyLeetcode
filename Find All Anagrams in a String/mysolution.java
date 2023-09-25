class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans=new ArrayList();
        
        Map<Character,Integer> pmap=new HashMap();
        Map<Character,Integer> smap=new HashMap();    
        
        int n=s.length(),m=p.length();
        
        if(n<m)
            return ans;
        
        for(int i=0;i<m;i++)
        {
            char c=p.charAt(i);
            pmap.put(c,pmap.getOrDefault(c,0)+1);
        }
        
        int meet=0;
        
        for(int i=0;i<m;i++)
        {
            char c=s.charAt(i);
            smap.put(c,smap.getOrDefault(c,0)+1);
            
            if(pmap.containsKey(c)&&smap.get(c).intValue()==pmap.get(c).intValue())
                meet++;
        }
        
        if(meet==pmap.size())
        {
            ans.add(0);
        }
        
        int start=0, end=m;
        
        while(end<n)
        {
            char c1=s.charAt(start++);
            
            if(pmap.containsKey(c1)&&pmap.get(c1).intValue()==smap.get(c1).intValue())
                meet--;
            
            smap.put(c1,smap.get(c1)-1);
            
            char c2=s.charAt(end++);
            
            smap.put(c2,smap.getOrDefault(c2,0)+1);
            
            if(pmap.containsKey(c2)&&pmap.get(c2).intValue()==smap.get(c2).intValue())
                meet++;
            
            if(meet==pmap.size())
                ans.add(start);
        }
        
        return ans;
    }
}