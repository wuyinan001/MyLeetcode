class Solution {
    public String makeFancyString(String s) {
        
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        char prev='a';
        int count=0;
        
        prev=s.charAt(0);
        sb.append(prev);
        count++;
        
        for(int i=1;i<n;i++)
        {
            char c=s.charAt(i);
            
            if(c==prev)
            {
                count++;
            
                if(count<3)
                    sb.append(c);
            }
            else
            {
                count=1;
                sb.append(c);
                prev=c;
            }
        }
        
        return sb.toString();
    }
}