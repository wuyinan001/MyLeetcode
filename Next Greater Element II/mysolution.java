class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n=nums.length;
        int[] append=new int[2*n-1];
        int[] index=new int[2*n-1];
        for(int i=0;i<n;i++)
            append[i]=nums[i];
        
        for(int i=n;i<2*n-1;i++)
            append[i]=nums[i-n];
        
        Stack<Integer> stack=new Stack();
        index[2*n-2]=-1;
        for(int i=2*n-2;i>=0;i--)
        {
            while(!stack.isEmpty()&&append[stack.peek()]<=append[i])
            {
                stack.pop();
            }
            
            if(stack.isEmpty())
                index[i]=-1;
            else
                index[i]=stack.peek();
            
            stack.push(i);
        }
        
        int[] ans=new int[n];
        
        for(int i=0;i<n;i++)
            if(index[i]!=-1)
                ans[i]=append[index[i]];
            else
                ans[i]=-1;
        
        return ans;
    }
}