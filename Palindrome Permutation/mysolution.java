class Solution {
    public boolean canPermutePalindrome(String s) {
        
        int[] freq=new int[128];
        
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)]++;
        
        int count=0;
        for(int i=0;i<128;i++)
        {
            if(freq[i]%2!=0)
                count++;
            
            if(count>=2)
                return false;
        }
        
        return true;
    }
}