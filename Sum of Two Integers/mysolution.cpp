class Solution {
public:
    int getSum(int a, int b) {
        int x=abs(a), y=abs(b);
        
        if(y>x)
            return getSum(b,a);
        
        int sign=1;
        
        if(a<0)
            sign=-1;
        
        if(a*b>=0)
        {
            int x2=1,y2=1;
            
            while(y!=0)
            {
                x2=x^y;
                y2=(x&y)<<1;
                x=x2;
                y=y2;
            }
            
        }
        else
        {
            int x2=1,y2=1;
            
            while(y!=0)
            {
                x2=x^y;
                y2=((~x)&y)<<1;
                x=x2;
                y=y2;
            }
        }
        
        return sign*x;
    }
};