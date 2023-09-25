class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> table=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(table.containsKey(nums[i]))
                table.put(nums[i],1+table.get(nums[i]));
            else
                table.put(nums[i],1);
        }
        
        for(Integer i:table.keySet())
            if(table.get(i)==1)
                return i;
        return 0;
    }
}