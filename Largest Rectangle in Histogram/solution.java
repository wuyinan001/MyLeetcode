class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int ans=0;
        int n=heights.length;
        
        Stack<Integer> stack=new Stack();
        
        stack.push(-1);
        
        for(int i=0;i<n;i++)
        {
            while(stack.peek()!=-1&&heights[stack.peek()]>heights[i])
            {
                int height=heights[stack.pop()];
                int width=i-stack.peek()-1;
                
                ans=Math.max(ans,height*width);
            }
            
            stack.push(i);
        }
        
        while(stack.peek()!=-1)
        {
            int height=heights[stack.pop()];
            int width=n-stack.peek()-1;
            
            ans=Math.max(ans,height*width);
        }
        
        
        return ans;
    }
}