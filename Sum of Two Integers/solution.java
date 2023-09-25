class Solution {
    public int getSum(int a, int b) {
        
        int x=Math.abs(a), y=Math.abs(b);
        
        if(x<y)
            return getSum(b,a);
        
        int sign= a>=0 ? 1 : -1;
        
        if(a*b>=0)
        {
            int x_temp,carry;
            
            while(true)
            {
                x_temp=x^y;
                carry=(x&y)<<1;
                x=x_temp;
                y=carry;
                if(carry==0)
                    break;
            }
            
        }
        else
        {
            int x_temp,borrow;
            
            while(true)
            {
                x_temp=x^y;
                borrow=((~x)&y)<<1;
                x=x_temp;
                y=borrow;
                if(borrow==0)
                    break;
            }
        }
        
        
        return sign*x;
    }
}