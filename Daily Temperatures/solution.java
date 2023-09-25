class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int n=T.length;
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&T[i]>=T[stack.peek()])
                stack.pop();
            
            ans[i]=stack.isEmpty()? 0 : stack.peek()-i;
            
            stack.push(i);
        }
        
        return ans;
    }
}