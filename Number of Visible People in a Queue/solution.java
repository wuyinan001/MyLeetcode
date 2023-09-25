class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        Stack<Integer> stack=new Stack();
        
        int n=heights.length;
        
        int[] ans=new int[n];
        
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&stack.peek()<heights[i])
            {
                stack.pop();
                ans[i]++;
            }
            
            if(!stack.isEmpty())
                ans[i]++;
            
            stack.push(heights[i]);
        }
        
        return ans;
    }
}