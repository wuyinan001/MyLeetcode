class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length())
            return false;
        
        int[] letters=new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            int c=s.charAt(i)-'a';
            letters[c]++;
        }
        
        for(int i=0;i<t.length();i++)
        {
            int c=t.charAt(i)-'a';
            letters[c]--;
            
            if(letters[c]<0)
                return false;
        }
        
        return true;
    }
}