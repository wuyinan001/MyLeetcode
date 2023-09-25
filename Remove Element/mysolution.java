class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            //System.out.println(i);
            
            if(nums[i]==val)
            {
                count++;
                
                for(int j=i+1;j<n;j++)
                {
                    nums[j-1]=nums[j];
                }
                
                nums[n-1]=val+1;
                
                i--;
            }
        }
        
        return n-count;
    }
}