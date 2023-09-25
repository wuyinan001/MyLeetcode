class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n=nums.length;
        int[] ans=new int[n];
        
        int min_index=0;
        int min=Math.abs(nums[0]);
        
        for(int i=1;i<n;i++)
            if(Math.abs(nums[i])<=min)
            {
                min_index=i;
                min=Math.abs(nums[i]);
            }
            else
                break;
        
        ans[0]=min*min;
        
        int k1=min_index-1,k2=min_index+1;
        
        for(int i=1;i<n;i++)
        {
            if(k1<0)
            {
                ans[i]=nums[k2]*nums[k2];
                k2++;
            }
            else if(k2>=n)
            {
                ans[i]=nums[k1]*nums[k1];
                k1--;
            }
            else if(Math.abs(nums[k1])<=Math.abs(nums[k2]))
            {
                ans[i]=nums[k1]*nums[k1];
                k1--;
            }
            else
            {
                ans[i]=nums[k2]*nums[k2];
                k2++;
            }
                
        }
        
        return ans;
        
    }
}