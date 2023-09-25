class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] L=new int[n];
        
        // One num case
        if(s.substring(0,1).equals("0"))
            L[0]=0;
        else
            L[0]=1;
        
        if(n==1)
            return L[0];
        
        // Two num case
        
        if(L[0]==0)
            return 0;
        
        int num1=Integer.parseInt(s.substring(0,2));
        int num2=Integer.parseInt(s.substring(1,2));
        
        if(num1>26&&num2==0)
            L[1]=0;
        else if(num1>26&&num2!=0)
            L[1]=1;
        else if(num1<=26&&num2==0)
            L[1]=1;
        else
            L[1]=2;
        
        
        // More than 2 num case        
        
        for(int i=2;i<n;i++)
        {
            if(L[i-1]==0||L[i-2]==0)
                return 0;
            
            num1=Integer.parseInt(s.substring(i-1,i+1));
            num2=Integer.parseInt(s.substring(i,i+1));
            
            if(num1>26&&num2==0)
                L[i]=0;
            else if(num1==0&&num2==0)
                L[i]=0;
            else if(num2==0)
                L[i]=L[i-2];
            else if(num1<10)
                L[i]=L[i-1];
            else if(num1>26)
                L[i]=L[i-1];
            else
                L[i]=L[i-1]+L[i-2];
        }
        
        return L[n-1];
    }
}