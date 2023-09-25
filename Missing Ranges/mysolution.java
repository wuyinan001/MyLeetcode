class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> ans=new ArrayList();
        
        int n=nums.length;
        
        if(n==0)
        {
            if(upper>lower)
                ans.add(lower+"->"+upper);
            else 
                ans.add(""+lower);
            
            return  ans;
        }
        
        for(int i=0;i<n;i++)
        {
            if(i==0&&nums[i]>lower)
            {
                if(nums[i]-lower==1)
                    ans.add(""+lower);
                else
                    ans.add(lower+"->"+(nums[i]-1));
            }
            
            if(i==n-1&&nums[i]<upper)
            {
                if(upper-nums[i]==1)
                    ans.add(""+upper);
                else
                    ans.add((nums[i]+1)+"->"+upper);
            }
            
            if(i<n-1)
            {
                if(nums[i+1]-nums[i]>2)
                    ans.add((nums[i]+1)+"->"+(nums[i+1]-1));
                else if(nums[i+1]-nums[i]==2)
                    ans.add(""+(nums[i]+1));
            }
        }
        
        return ans;
        
    }
}