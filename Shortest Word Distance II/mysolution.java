class WordDistance {
    
    Map<String,List<Integer>> map;
    
    public WordDistance(String[] wordsDict) {
        
        map=new HashMap();
        
        for(int i=0;i<wordsDict.length;i++)
        {
            String s=wordsDict[i];
            
            if(!map.containsKey(s))
                map.put(s,new ArrayList());
            
            map.get(s).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        
        List<Integer> list1=map.get(word1);
        List<Integer> list2=map.get(word2);
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<list1.size();i++)
            for(int j=0;j<list2.size();j++)
                min=Math.min(min,Math.abs(list1.get(i)-list2.get(j)));
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */