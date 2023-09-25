class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] ans=new int[k];

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Map.Entry<Integer,Integer>> list=new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int count=0;
        for(Map.Entry<Integer,Integer> aa:list)
        {
            ans[count++]=aa.getKey();
            if(count>=k)
                break;
        }

        return ans;
        
    }
}