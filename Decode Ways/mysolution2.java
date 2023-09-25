class Solution {
    public int numDecodings(String s) {
        
        int n=s.length();
        
        if(n==0)
            return 0;
        
        if(n==1)
        {
            if(s.equals("0"))
                return 0;
            else
                return 1;
        }
        
        if(n==2)
        {
            if(s.charAt(0)=='0')
                return 0;
            
            if(s.charAt(1)=='0')
            {
                if(s.charAt(0)=='1'||s.charAt(0)=='2')
                    return 1;
                else
                    return 0;
            }
            
            int x=Integer.parseInt(s);
            
            if(x<=26)
                return 2;
            else
                return 1;
        }
        
        // L[i]=L[i-1]*a+L[i-2]*b
        // a: number of decode ways for s[i]
        // b: number of decode ways for s[i-1,i] not including single digits
        int[] L=new int[n];
        
        if(s.charAt(0)=='0')
            L[0]=0;
        else
            L[0]=1;
        
        if(s.charAt(0)=='0')
            L[1]=0;
        else if(s.charAt(1)=='0')
        {
            if(s.charAt(0)=='1'||s.charAt(0)=='2')
                L[1]=1;
            else
                L[1]=0;
        }
        else
        {
            int x=Integer.parseInt(s.substring(0,2));
            
            if(x<=26)
                L[1]=2;
            else
                L[1]=1;
        }
        
        for(int i=2;i<n;i++)
        {
            int a=0,b=0;
            
            if(s.charAt(i)!='0')
                a=1;
            
            if(s.charAt(i-1)!='0'&&Integer.parseInt(s.substring(i-1,i+1))<=26)
                b=1;
            
            L[i]=L[i-1]*a+L[i-2]*b;
        }
        
        return L[n-1];
    }
    
}