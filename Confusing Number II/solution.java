class Solution {
    
    private long getRotate(long n)
    {
        long sum=0;
        
        while(n>0)
        {
            long k=n%10;
            
            if(k==6)
                k=9;
            else if(k==9)
                k=6;
            
            sum=sum*10+k;
            n=n/10;
        }
        
        return sum;
    }
    
    public int confusingNumberII(int N) {
        
        int ans=0;
        long n=N;
        
        Stack<Long> stack=new Stack();
        
        stack.push(1l);
        stack.push(6l);
        stack.push(8l);
        stack.push(9l);
       
        while(!stack.isEmpty())
        {
            long curr=stack.pop();
            
            long rotate=getRotate(curr);
            
            if(curr!=rotate&&curr<=n)
                ans++;
            
            long ten=curr*10;
            
            if(ten<=n)
                stack.push(ten);
            if(ten+1<=n)
                stack.push(ten+1);
            if(ten+6<=n)
                stack.push(ten+6);
            if(ten+8<=n)
                stack.push(ten+8);
            if(ten+9<=n)
                stack.push(ten+9);
        }
            
        return ans;
    }
}