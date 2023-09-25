class Solution {
    public int compress(char[] chars) {
        
        int n=chars.length;
        StringBuilder sb=new StringBuilder();
        
        char prev=chars[0];
        int count=1;
        
        for(int i=1;i<n;i++)
        {
            if(prev!=chars[i])
            {
                sb.append(prev);
                if(count!=1)
                    sb.append(count);
                prev=chars[i];
                count=1;
            }
            else
            {
                count++;
            }
        }
        
        if(sb.length()==0||sb.charAt(sb.length()-1)!=chars[n-1])
        {
            sb.append(chars[n-1]);
            
            if(count!=1)
                sb.append(count);
        }
        
        int ans=sb.length();
        for(int i=0;i<ans;i++)
        {
            chars[i]=sb.charAt(i);
        }
        
        return ans;
    }
}