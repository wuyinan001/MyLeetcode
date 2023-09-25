class Solution {
    public int hammingDistance(int x, int y) {
        
        int sum=0;
        
        for(int i=1;i<=32;i++)
        {
            sum+=(x&1)^(y&1);
            x=x>>>1;
            y=y>>>1;
        }
        
        return sum;
    }
}