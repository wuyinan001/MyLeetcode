class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer,Integer> map=new HashMap();
        
        int sum=0, n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            sum%=k;
            
            if(sum==0&&i>0)
                return true;
            
            if(map.containsKey(sum)&&i-map.get(sum)>1)
                return true;
            
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        
        return false;
    }
}