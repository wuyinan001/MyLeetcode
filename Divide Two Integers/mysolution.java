class Solution {
    public int divide(int dividend, int divisor) {
        
        long y=(long)Math.abs((long)dividend);
        long x=(long)Math.abs((long)divisor);
        
        int sign=1;
        
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0))
            sign=-1;
        
        long result;
        
        //System.out.println("x: "+x);
        //System.out.println("y: "+y);
        
        if(x==1)
            result=y;
        else
        {
            for(result=1;result*x<=y;result++);
            result--;
        }
        
        //System.out.println("result: "+result);
        //System.out.println("sign: "+sign);
        
        if(result>Integer.MAX_VALUE&&sign==1)
            return Integer.MAX_VALUE;
        
        
        
        return (int)(sign*result);
    }
}