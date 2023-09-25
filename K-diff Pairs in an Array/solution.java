class Solution {
    public int findPairs(int[] nums, int k) {
        
        int n=nums.length;
        // pairs set contain unique min integers in each pairs that diff k
        Set<Integer> pairs=new HashSet<Integer>();
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(Math.abs(nums[i]-nums[j])==k)
                    pairs.add(Math.min(nums[i],nums[j]));
            }
        }
        
        return pairs.size();
    }
}