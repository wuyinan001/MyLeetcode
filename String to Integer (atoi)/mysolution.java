class Solution {
    public int myAtoi(String s) {
        
        if(s==null||s.equals(""))
            return 0;
        
        int i=0;
        
        // Find the first index that s.charAt(i)!=' '
        while(i<s.length()&&s.charAt(i)==' ')
            i++;
        
        if(i==s.length())
            return 0;
        
        char first=s.charAt(i);
        
        //System.out.println(first);
        
        if(first!='+'&&first!='-'&&(first<'0'||first>'9'))
            return 0;
        
        int end=i;
        
        if(s.charAt(end)=='+'||s.charAt(end)=='-')
            end++;
        
        while(end<s.length()&&s.charAt(end)>='0'&&s.charAt(end)<='9')
            end++;
        
        // Extract valid digits part from s
        s=s.substring(i,end);
        
        System.out.println(s);
        
        if(s.equals("-")||s.equals("+"))
            return 0;
        
        boolean positive=false;
        
        if(s.charAt(0)!='-')
            positive=true;
        
        long sum=0;
        
        for(int k=0;k<s.length();k++)
        {
            if(positive&&sum>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if(!positive&&(sum-1>Integer.MAX_VALUE))
                return Integer.MIN_VALUE;
            
            sum=sum*10;
            if(s.charAt(k)=='+'||s.charAt(k)=='-')
                continue;
            
            int a=s.charAt(k)-'0';
            sum+=a;
            
        }
        
        System.out.println("sum "+sum+" positive "+positive);
        //System.out.println(sum-1>Integer.MAX_VALUE);
        if(positive&&sum>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if(!positive&&(sum-1>Integer.MAX_VALUE))
            return Integer.MIN_VALUE;
        
        
        if(positive)
            return (int)sum;
        else
            return -(int)sum;
    
    }
}