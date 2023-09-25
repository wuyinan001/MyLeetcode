class Solution {
    
    private int multiply(String s, char c)
    {
        if(c=='0')
            return 0;
        
        int sum=0, carry=1, n=s.length();
        int b=c-'0';
        
        for(int i=n-1;i>=0;i--)
        {
            int a=s.charAt(i)-'0';
            
            int product=a*b;
            
            sum+=product*carry;
            carry=carry*10;
            
        }
        
        return sum;
    }
    
    public String multiply(String num1, String num2) {
        
        int sum=0, carry=1, n=num2.length();
        
        for(int i=n-1;i>=0;i--)
        {
            char c=num2.charAt(i);
            
            int product=multiply(num1,c);
            
            sum+=product*carry;
            carry=carry*10;
        }
        
        return Integer.toString(sum);
    }
}