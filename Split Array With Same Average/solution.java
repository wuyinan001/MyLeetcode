class Solution {
    
    // sum1=(len1*total)/n;
    Map<String,Boolean> map;
    
    public boolean splitArraySameAverage(int[] nums) {
        
        map=new HashMap();
        int n=nums.length, total=0;
        
        for(int i:nums)
            total+=i;
        
        for(int count=1;count<n;count++)
        {
            if((count*total)%n==0)
                if(dp(nums,0,count,(count*total)/n))
                    return true;
        }
        
        return  false;
    }
    
    private boolean dp(int[] nums, int index, int count, int sum)
    {
        if(sum==0&&count==0)
            return true;
        
        if(index==nums.length||count==0)
            return false;
        
        String key=index+":"+count+":"+sum;
        
        if(map.containsKey(key))
            return map.get(key);
        
        boolean ans=false;
        
        if(sum>=nums[index])
            ans=dp(nums,index+1,count-1,sum-nums[index])||dp(nums,index+1,count,sum);
        else
            ans=dp(nums,index+1,count,sum);
            
        map.put(key,ans);
        return ans;
    }
}