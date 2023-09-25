class Solution {
    public String getHint(String secret, String guess) {
        
        Map<Character,Integer> map=new HashMap();
        Set<Integer> set=new HashSet();
        
        int n=secret.length(), a=0, b=0;
        
        for(int i=0;i<n;i++)
        {
            char c=secret.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(int i=0;i<n;i++)
        {
            char c=guess.charAt(i);
            if(c==secret.charAt(i))
            {
                a++;
                if(map.get(c)==1)
                    map.remove(c);
                else
                    map.put(c,map.get(c)-1);
                set.add(i);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(!set.contains(i))
            {
                char c=guess.charAt(i);
                if(map.containsKey(c))
                {
                    b++;
                    if(map.get(c)==1)
                        map.remove(c);
                    else
                        map.put(c,map.get(c)-1);
                }
            }
        }
        
        return a+"A"+b+"B";
    }
}