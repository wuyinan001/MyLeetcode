class Solution {
    public String convertToTitle(int n) {
        
        StringBuilder sb=new StringBuilder();
        
        while(n>0)
        {
            int a=n%26;
            
            if(a==0)
            {
                sb.append((char)('Z'));
                n=n/26-1;
            }
            else
            {
                sb.append((char)('A'+a-1));
                n=n/26;
            }
            
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}