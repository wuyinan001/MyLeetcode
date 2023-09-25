class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        // map Key: unique element in nums
        // map Value: the index of the last appearance of that key in nums array
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i])&&i-map.get(nums[i])<=k)
                return true;
            map.put(nums[i],i);
        }
        
        return false;
    }
}