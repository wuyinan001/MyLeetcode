class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        Map<Character,Integer> map=new HashMap();
        
        map.put(keysPressed.charAt(0),releaseTimes[0]);
        
        for(int i=1;i<releaseTimes.length;i++)
        {
            int curr=releaseTimes[i]-releaseTimes[i-1];
            
            char c=keysPressed.charAt(i);
            
            if(!map.containsKey(c)||map.get(c)<curr)
                map.put(c,curr);        
        }
        
        List<Character> list=new ArrayList(map.keySet());
        
        Collections.sort(list, new Comparator<Character>(){
            
            public int compare(Character c1, Character c2)
            {
                if(map.get(c1)==map.get(c2))
                    return c2-c1;
                else
                    return map.get(c2)-map.get(c1);
            }
            
        });
        
        return list.get(0);
    }
}