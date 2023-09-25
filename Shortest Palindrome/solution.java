class Solution {
    
    // Find the ending index of longest palindrome substring of s starting at index 0
    private int longestPalindromeSubstring(String s)
    {
        int end=0;
        int n=s.length();
        
        StringBuilder sb=new StringBuilder(s);
        String rev=sb.reverse().toString();
        
        int shift=0;
        
        while(shift<n)
        {
            if(s.substring(0,n-shift).equals(rev.substring(shift)))
            {
                return n-1-shift;
            }
            
            shift++;
        }
        
        return end;
        
    }
    
    public String shortestPalindrome(String s) {
        
        int n=s.length();
        
        if(n<=1)
            return s;
        
        int end=longestPalindromeSubstring(s);
        
        if(end==n-1)
            return s;
        
        StringBuilder sb=new StringBuilder(s);
        StringBuilder prefix=new StringBuilder(s.substring(end+1));
        prefix.reverse();
        
        prefix.append(sb);
        
        return prefix.toString();
    }
}
