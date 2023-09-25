class Solution {
    public String getHint(String secret, String guess) {
        
        int a=0,b=0;
        
        int n=secret.length();
        
        Map<Character,Integer> map1=new HashMap();
        Map<Character,Integer> map2=new HashMap();
        
        for(int i=0;i<n;i++)
        {
            char c1=secret.charAt(i), c2=guess.charAt(i);
            if(c1==c2)
            {
                a++;
            }
            else
            {
                map1.put(c1,map1.getOrDefault(c1,0)+1);
                map2.put(c2,map2.getOrDefault(c2,0)+1);
            }
        }
        
        for(char c:map1.keySet())
        {
            if(map2.containsKey(c))
            {
                b+=Math.min(map1.get(c),map2.get(c));
            }
        }
        
        return a+"A"+b+"B";
    }
}