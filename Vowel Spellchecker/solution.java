class Solution {
    
    Set<Character> vowel=new HashSet();
    Set<String> wordSet=new HashSet();
    Map<String,String> wordC=new HashMap();
    Map<String,String> wordV=new HashMap();
    
    private String devowel(String word)
    {
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(!vowel.contains(c))
                sb.append(c);
            else
                sb.append('*');
        }
        
        return sb.toString();
    }
    
    private String solve(String q)
    {
        if(wordSet.contains(q))
            return q;

        q=q.toLowerCase();

        if(wordC.containsKey(q))
            return wordC.get(q);

        q=devowel(q);

        if(wordV.containsKey(q))
            return wordV.get(q);

        return "";
    }
    
    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        
        
        for(String word:wordlist)
        {
            wordSet.add(word);
            
            String w=word.toLowerCase();
            
            if(!wordC.containsKey(w))
                wordC.put(w,word);
            
            w=devowel(w);
            
            if(!wordV.containsKey(w))
                wordV.put(w,word);
        }
        
        int n=queries.length;
        
        String[] ans=new String[n];
        
        for(int i=0;i<n;i++)
        {
            ans[i]=solve(queries[i]);
        }
        
        return ans;
    }
}

