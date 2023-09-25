class Solution {
    public int myAtoi(String s) {
        
        int n=s.length();
        long num=0;
        long sign=1;
        char prev=' ';
        
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            
            if(c==' '&&prev==' ')
                continue;
            else if(c==' ')
                break;
            
            if(c=='-'&&prev==' ')
                sign=-1;
            else if(c=='+'&&prev==' ')
                sign=1;
            else if(c>='0'&&c<='9')
            {
                if(num*sign<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                else if(num*sign>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                num=num*10+(c-'0');
            }
                
            else
                break;
            
            prev=c;
        }
        
        System.out.println(num);
        
        if(num*sign<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if(num*sign>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)(num*sign);
    }
}