class Solution {
    public boolean isHappy(int n) {
        // To store previous numbers
        // If new sum of squares exists in previous numbers list before hitting 1, then this number is not a happy number
        int[] prev=new int[1000];
        int m=-1;
        
        while(n!=1)
        {
            if(has(prev,m,n))
                return false;
            
            prev[++m]=n;
            
            n=convert(n);
        }
        
        return true;
        
    }
    
    // Check if a exists in nums from index 0 to n
    private boolean has(int[] nums, int n, int a)
    {
        
        for(int i=0;i<n;i++)
        {
            if(a==nums[i])
                return true;
        }
        
        return false;
    }
    
    // This function convert the input number to sum of squares of each digits
    // for example, input 19 output 82
    private int convert(int n)
    {
        int sum=0;
        
        while(n>0)
        {
            sum=sum+(n%10)*(n%10);
            
            n=n/10;
        }
        
        return sum;
    }
}