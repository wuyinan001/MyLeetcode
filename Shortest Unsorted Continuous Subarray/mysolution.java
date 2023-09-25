class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n=nums.length;
        int[] copy=new int[n];
        
        for(int i=0;i<n;i++)
            copy[i]=nums[i];
        
        Arrays.sort(nums);
        
        int left=0,right=n-1;
        
        while(left<n)
        {
            if(nums[left]!=copy[left])
                break;
            left++;
        }
        
        while(right>=0)
        {
            if(nums[right]!=copy[right])
                break;
            right--;
        }
        
        if(right<left)
            return 0;
        
        return right-left+1;
    }
}