class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord))
            return 0;
        
        Map<String,Integer> map=new HashMap<>();
        Map<String,Integer> distance=new HashMap<>();
        //int ans=0;
        
        for(String s:wordList)
        {
            map.put(s,0);
        }
        
        Queue<String> queue=new LinkedList<>();
        
        queue.add(beginWord);
        map.put(beginWord,1);
        distance.put(beginWord,0);
        
        while(!queue.isEmpty())
        {   
            String s=queue.remove();
            
            //System.out.println("Distance:");
            //print(distance);
            
            for(String v:wordList)
            {
                if(map.get(v)==0&&oneLetterDiff(s,v))
                {
                    distance.put(v,distance.get(s)+1);
                    map.put(v,1);
                    queue.add(v);
                    
                    if(v.equals(endWord))
                        return distance.get(v)+1;
                }
            }
            
        }
        
        return 0;
    }
    
    private void print(Map<String,Integer> map)
    {
        for(Map.Entry<String,Integer> m:map.entrySet())
        {
            System.out.println(m.getKey()+": "+m.getValue());
        }
    }
    
    private boolean oneLetterDiff(String s1, String s2)
    {
        int count=0;
        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
        return count==1;
    }
}