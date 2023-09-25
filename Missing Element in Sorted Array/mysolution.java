class Solution {
    public int missingElement(int[] nums, int k) {
        
        int n=nums.length, curr=1;
        
        for(int i=nums[0]+1;i<=Integer.MAX_VALUE;i++)
        {
            if(curr<n&&i==nums[curr])
                curr++;
            else 
            {
                if(k==1)
                    return i;
                else
                    k--;
            }
        }
        
        return -1;
    }
}