class Solution {
    
    int m;
    String[] words;
    Map<String,List<String>> prefixMap;
    
    private void backTrack(String[] words, List<List<String>> ans, LinkedList<String> list)
    {
        if(list.size()==m)
        {
            ans.add(new ArrayList(list));
            return;
        }
        
        StringBuilder sb=new StringBuilder();
        int index=list.size();
        for(String s:list)
        {
            sb.append(s.charAt(index));
        }
        String prefix=sb.toString();
        
        if(prefixMap.containsKey(prefix))
        {
            for(String word:prefixMap.get(prefix))
            {
                list.add(word);
                backTrack(words,ans,list);
                list.removeLast();
            }
        }
        
    }
    
    public List<List<String>> wordSquares(String[] words) {
        
        m=words[0].length();
        this.words=words;
        prefixMap=new HashMap();
        
        getPrefix();
        
        List<List<String>> ans=new ArrayList();
        backTrack(words,ans,new LinkedList());
        
        return ans;
    }
    
    private void getPrefix()
    {
        for(String word:words)
        {
            for(int i=1;i<m;i++)
            {
                String prefix=word.substring(0,i);
                if(!prefixMap.containsKey(prefix))
                    prefixMap.put(prefix,new ArrayList());
                
                prefixMap.get(prefix).add(word);
            }
        }
        
        prefixMap.put("",new ArrayList());
        
        for(String word:words)
            prefixMap.get("").add(word);
    }
}