class Solution {
    public int trap(int[] height) {
        
        int n=height.length;
        
        int[] leftside=new int[n];
        int[] rightside=new int[n];
        
        int sum=0,max=0;
        
        for(int i=0;i<n;i++)
        {
            if(height[i]>max)
            {
                max=height[i];
            }
            else
            {
                leftside[i]=max-height[i];
            }
        }
        
        max=0;
        
        for(int i=n-1;i>=0;i--)
        {
            if(height[i]>max)
            {
                max=height[i];
            }
            else
            {
                rightside[i]=max-height[i];
            }
        }
        
        for(int i=0;i<n;i++)
        {
            sum=sum+Math.min(leftside[i],rightside[i]);
        }
        
        return sum;
    }
}