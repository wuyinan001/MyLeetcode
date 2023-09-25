class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int n=s.length();
        
        int start=0, end=0;
        
        Map<Character,Integer> map1=new HashMap();
        Map<String,Integer> map2=new HashMap();
        
        for(int size=minSize;size<=maxSize;size++)
        {
            start=0;
            end=0;
            while(end<n)
            {
                char c=s.charAt(end);
                
                map1.put(c,map1.getOrDefault(c,0)+1);
                
                if(end>=size-1)
                {
                    if(map1.size()<=maxLetters)
                    {
                        String str=s.substring(start,end+1);
                        map2.put(str,map2.getOrDefault(str,0)+1);
                    }
                        
                    
                    char c2=s.charAt(start++);
                    
                    if(map1.get(c2)==1)
                        map1.remove(c2);
                    else
                        map1.put(c2,map1.get(c2)-1);
                }
                
                end++;
            }
        }
        
        if(map2.size()==0)
            return 0;
        
        /*
        for(String str:map2.keySet())
            System.out.println(str+" "+map2.get(str));*/
        
        List<Integer> list=new ArrayList(map2.values());
        
        Collections.sort(list,new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                return a2-a1;
            }
            
        });
        
        return list.get(0);
    }
}