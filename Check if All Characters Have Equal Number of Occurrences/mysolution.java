class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        Map<Character,Integer> map=new HashMap();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int freq=map.get(s.charAt(0));
        
        for(char key:map.keySet())
            if(map.get(key)!=freq)
                return false;
        
        return true;
    }
}