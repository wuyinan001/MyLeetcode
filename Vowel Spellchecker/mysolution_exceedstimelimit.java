class Solution {
    
    Map<String,List<String>> map=new HashMap();
    Set<Character> vowel=new HashSet();
    
    
    private void backTrack(String word, List<String> list, int index)
    {
        if(index==word.length())
        {
            list.add(word);
            return;
        }
        
        if(vowel.contains(word.charAt(index)))
        {
            for(char v:vowel)
            {
                StringBuilder sb=new StringBuilder(word);
                sb.setCharAt(index,v);
                backTrack(sb.toString(),list,index+1);
            }
        }
        else
            backTrack(word,list,index+1);
    }
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        
        Set<String> wordSet=new HashSet();
        
        for(String word:wordlist)
        {
            wordSet.add(word);
            String w=word.toLowerCase();
            
            if(!map.containsKey(w))
                map.put(w,new ArrayList());
            
            map.get(w).add(word);
        }
        
        int n=queries.length;
        
        String[] ans=new String[n];
        
        for(int i=0;i<n;i++)
        {
            if(wordSet.contains(queries[i]))
            {
                ans[i]=queries[i];
                continue;
            }
            
            String q=queries[i].toLowerCase();
            
            if(map.containsKey(q))
            {
                ans[i]=map.get(q).get(0);
                continue;
            }
            
            List<String> list=new ArrayList();
            boolean found=false;
            
            backTrack(q,list,0);
            
            for(String word:wordlist)
            {
                String key=word.toLowerCase();
                if(list.contains(key))
                {
                    ans[i]=word;
                    found=true;
                    break;
                }
            }
            
            if(!found)
                ans[i]="";
        }
        
        return ans;
    }
}