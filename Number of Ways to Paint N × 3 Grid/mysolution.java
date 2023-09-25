class Solution {
    public int numOfWays(int n) {
        
        // Odd: Three colors are different, e.g., RGB
        // Even: Two colors at two ends are the same, e.g., RGR
        // If the current row is odd, then there are 2 odd options and 2 even options in the next row;
        // If the current row is even, then there are 2 odd options and 3 even options in the next row;
        
        long[] odd=new long[n];
        long[] even=new long[n];
        
        odd[0]=6;
        even[0]=6;
        
        long mod=(long)(1e9+7);
        
        for(int i=1;i<n;i++)
        {
            odd[i]=2*odd[i-1]+2*even[i-1];
            even[i]=2*odd[i-1]+3*even[i-1];
            
            odd[i]=odd[i]%mod;
            even[i]=even[i]%mod;
            
        }
        
        
        return (int)((odd[n-1]+even[n-1])%mod);
    }
}