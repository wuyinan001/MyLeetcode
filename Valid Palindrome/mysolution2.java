class Solution {
    public boolean isPalindrome(String s) {
        
        String s1=s.replaceAll("[^a-zA-Z0-9]","");
        String s2=s1.toLowerCase();
        
        System.out.println(s2);
        
        int n=s2.length();
        
        for(int i=0;i<n/2;i++)
            if(s2.charAt(i)!=s2.charAt(n-i-1))
                return false;
        
        return true;
    }
}