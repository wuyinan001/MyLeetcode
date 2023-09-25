class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        List<Map.Entry<Integer,Integer>> list=new LinkedList<>(map.entrySet());
        
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        
        return list.get(0).getKey();
    }
}