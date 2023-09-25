class Solution {
    public boolean isPalindrome(int x) {
        
        String s=Integer.toString(x);
        
        char[] array=s.toCharArray();
        
        int n=array.length;
        
        for(int i=0;i<Math.ceil(n/2);i++)
        {
            if(array[i]!=array[n-1-i])
                return false;
        }
        
        return true;
    }
}