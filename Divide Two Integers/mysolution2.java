class Solution {
    public int divide(int dividend, int divisor) {
        
        int sign=1;
        long a=(long)dividend, b=(long)divisor;
        
        long x=Math.abs(a), y=Math.abs(b);
        
        System.out.println(a+" : "+b);
        System.out.println(x+" : "+y);
        
        if(a!=0&&(a/x)*(b/y)==-1)
            sign=-1;
        
        int ans=0;
        
        if((sign*x/y)>Integer.MAX_VALUE)
            ans=Integer.MAX_VALUE;
        else
            ans=(int)(sign*(x/y));
        
        return ans;
        
    }
}