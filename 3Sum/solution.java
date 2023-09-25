class Solution {
    
    private void twoSum(int[] nums, int start, List<List<Integer>> list)
    {
        Set<Integer> set=new HashSet();
        
        for(int i=start+1;i<nums.length;i++)
        {
            int cmp=-nums[start]-nums[i];
            if(set.contains(cmp))
            {
                list.add(Arrays.asList(nums[start],cmp,nums[i]));
                while(i+1<nums.length&&nums[i]==nums[i+1])
                    i++;
            }
                
            
            set.add(nums[i]);
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList();
        
        for(int i=0;i<nums.length&&nums[i]<=0;i++)
        {
            if(i==0||nums[i]!=nums[i-1])
                twoSum(nums,i,ans);
        }
        
        return ans;
    }
}