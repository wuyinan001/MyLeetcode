class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        
        int carry=0;
        
        digits[n-1]++;
            
        for(int j=n-1;j>0;j--)
        {
            if(carry==1)
                digits[j]++;
            
            if(digits[j]>=10)
            {
                carry=1;
                digits[j]-=10;
            }
            else
                carry=0;
        }
        
        if(carry==1)
            digits[0]++;
        
        if(digits[0]>=10)
        {
            int[] result=new int[n+1];
            
            result[0]=1;
            result[1]=0;
            
            for(int i=2;i<n+1;i++)
            {
                result[i]=digits[i-1];
            }
            
            return result;
        }
        else
            return digits;
    }
}