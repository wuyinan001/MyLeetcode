class Solution {
    
    private String convert(String s)
    {
        if(s.length()==0)
            return "";
        
        StringBuilder sb=new StringBuilder();
        
        char prev=s.charAt(0);
        int count=1;
        
        for(int i=1;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c==prev)
                count++;
            else
            {
                sb.append(prev);
                sb.append(count);
                prev=c;
                count=1;
            }
        }
        
        if(sb.length()==0||prev!=sb.charAt(sb.length()-1))
        {
            sb.append(prev);
            sb.append(count);
        }
        
        return sb.toString();
    }
    
    private boolean isStretchy(String target, String input)
    {
        //System.out.println(input);
        
        if(target.length()!=input.length())
            return false;
        
        int n=target.length();
        
        for(int i=0;i<n;i+=2)
        {
            if(target.charAt(i)!=input.charAt(i))
                return false;
            
            int k1=target.charAt(i+1)-'0', k2=input.charAt(i+1)-'0';
            
            if(k1<k2||(k1>k2&&k1<3))
                return false;
        }
        
        return true;
    }
    
    
    public int expressiveWords(String s, String[] words) {
        
        String target=convert(s);
        
        //System.out.println(target);
        
        int ans=0;
        
        for(String word:words)
            if(isStretchy(target,convert(word)))
                ans++;
        
        return ans;
    }
}