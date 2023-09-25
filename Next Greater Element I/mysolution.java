class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> map=new HashMap();
        
        Stack<Integer> stack=new Stack();
        
        int n=nums2.length;
        int[] nextGreater=new int[n];
        
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i])
                stack.pop();
            
            if(!stack.isEmpty())
                nextGreater[i]=stack.peek();
            else
                nextGreater[i]=-1;
            
            stack.add(i);
        }
        
        for(int i=0;i<n;i++)
            map.put(nums2[i],nextGreater[i]);
        
        int[] ans=new int[nums1.length];
        
        for(int i=0;i<nums1.length;i++)
        {
            ans[i]= map.get(nums1[i])==-1 ? -1 :  nums2[map.get(nums1[i])];
        }
            
        
        return ans;
    }
}