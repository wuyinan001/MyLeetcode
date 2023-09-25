class Solution {
    
    private String shift(String s, int n)
    {
        StringBuilder sb=new StringBuilder();
        int m=s.length();
        for(int i=0;i<m;i++)
            sb.append(s.charAt((i+n)%m));
        
        return sb.toString();
    }
    
    public boolean rotateString(String A, String B) {
        
        if(A.length()!=B.length())
            return false;
        
        int n=A.length();
        
        for(int i=0;i<=n;i++)
        {
            if(shift(A,i).equals(B))
                return true;
        }
        
        return false;
    }
}