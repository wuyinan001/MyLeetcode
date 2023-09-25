class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        
        if(n==0)
            return 1;
        
        int[] L=new int[11];
        
        L[1]=10;
        
        for(int i=2;i<=10;i++)
        {
            if(i<=9)
            {
                L[i]=L[i-1]+arange(9,i)+(i-1)*arange(9,i-1);
            }
            else
            {
                L[i]=arange(10,10)-arange(9,9)+L[9];
            }
        }
        
        return n<=10? L[n] : L[10];
    }
    
    private int arange(int m, int n)
    {
        if(n>m)
            return -1;
        
        int result=1;
        
        for(int i=1;i<=n;i++)
        {
            result=result*m;
            m--;
        }
        
        return result;
    }
}