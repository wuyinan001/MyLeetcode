class Solution {
    
    int[] index=new int[26];
    int[] curr=new int[26];
    
    private boolean contains(String word)
    {
        for(int i=0;i<26;i++)
            curr[i]=0;
        
        for(int i=0;i<word.length();i++)
        {
            int j=word.charAt(i)-'a';
            curr[j]++;
            if(curr[j]>index[j])
                return false;
        }
        
        return true;
    }
    
    public int countCharacters(String[] words, String chars) {
        
        for(int i=0;i<chars.length();i++)
            index[chars.charAt(i)-'a']++;
        
        int ans=0;
        
        for(String word:words)
            if(contains(word))
                ans+=word.length();
        
        return ans;
    }
}