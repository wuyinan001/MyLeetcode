class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans=new ArrayList();
        
        int n=nums.length;
        Arrays.sort(nums);
        
        int start=0,end=0, current=nums[0];
        
        while(end<n)
        {
            if(nums[end]!=current)
            {
                if(end-start>(int)Math.floor(n/3.0))
                    ans.add(nums[start]);
                
                current=nums[end];
                start=end;
            }
            
            end++;
        }
        
        if(nums[n-1]==current&&n-start>(int)Math.floor(n/3.0))
           ans.add(nums[start]);
        
        return ans;
    }
}