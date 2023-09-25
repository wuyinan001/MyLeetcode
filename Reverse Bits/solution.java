public class Solution {
    
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int power=31;
        int ans=0;
        
        while(n!=0)
        {
            ans+=(n&1)<<power;
            power--;
            n=n>>>1;
        }
     
        return ans;
    }
}