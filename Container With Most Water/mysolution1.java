class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        
        int result=0;
        
        for(int i=0;i<n-1;i++)
        {
            int max=0;
            for(int j=i+1;j<n;j++)
            {
                int v=Math.min(height[i],height[j])*(j-i);
                if(max<v)
                    max=v;
            }
            
            if(result<max)
                result=max;
        }
        
        return result;
    }
}