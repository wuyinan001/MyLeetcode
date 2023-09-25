class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly=new int[n];
        
        ugly[0]=1;
        
        int i2=0,i3=0,i5=0;
        
        int next_multiply_two=2,next_multiply_three=3,next_multiply_five=5;
        
        int next_ugly;
        
        for(int i=1;i<n;i++)
        {
            next_ugly=Math.min(next_multiply_two,Math.min(next_multiply_three,next_multiply_five));
            ugly[i]=next_ugly;
            
            if(next_ugly==next_multiply_two)
            {
                i2++;
                next_multiply_two=2*ugly[i2];
            }
            
            if(next_ugly==next_multiply_three)
            {
                i3++;
                next_multiply_three=3*ugly[i3];
            }
            
            if(next_ugly==next_multiply_five)
            {
                i5++;
                next_multiply_five=5*ugly[i5];
            }
        }
        
        return ugly[n-1];
    }
}