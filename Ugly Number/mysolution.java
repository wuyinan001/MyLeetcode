class Solution {
    public boolean isUgly(int num) {
        if(num<=0)
            return false;
        
        num=maxDivide(num,2);
        num=maxDivide(num,3);
        num=maxDivide(num,5);
        
        return num==1;
    }
    
    // Find the quotient of a after divided by b in maximum amount of divisions( with 0 remainder)
    private int maxDivide(int a, int b)
    {
        while(a%b==0)
            a=a/b;
        return a;
    }
}