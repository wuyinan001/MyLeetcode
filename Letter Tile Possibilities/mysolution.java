class Solution {
    
    int count=0;
    
    private void helper(int[] freq)
    {
        for(int i=0;i<26;i++)
        {
            if(freq[i]==0)
                continue;
            
            freq[i]--;
            count++;
            helper(freq);
            freq[i]++;
        }
    }
    
    public int numTilePossibilities(String tiles) {
        
        int[] freq=new int[26];
        
        for(int i=0;i<tiles.length();i++)
            freq[tiles.charAt(i)-'A']++;
        
        helper(freq);
        
        return count;
        
    }
}