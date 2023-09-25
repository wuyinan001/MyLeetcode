class Solution {
    public boolean canConvert(String str1, String str2) {
        
        Set<Character> set=new HashSet();
        Map<Character,Character> map=new HashMap();
        
        for(int i=0;i<str1.length();i++)
        {
            char c1=str1.charAt(i), c2=str2.charAt(i);
            
            set.add(c2);
            
            if(map.containsKey(c1)&&map.get(c1)!=c2)
                return false;
            
            map.put(c1,c2);
        }
        
        if(!str1.equals(str2)&&map.size()==26&&set.size()==26)
            return false;
        else
            return true;
    }
}