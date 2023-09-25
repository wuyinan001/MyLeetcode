class Solution {
    
    Map<Integer,Integer> map=new HashMap();
    List<Integer> keyList;
    int n;
    
    private void backTrack(List<List<Integer>> ans, List<Integer> list)
    {
        if(list.size()==n)
        {
            ans.add(list);
            return;
        }
        
        for(int key:map.keySet())
        {
            if(map.get(key)==0)
                continue;
            
            List<Integer> newList=new ArrayList(list);
            newList.add(key);
            
            map.put(key,map.get(key)-1);
            
            backTrack(ans,newList);
            
            map.put(key,map.get(key)+1);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList();
        n=nums.length;
        
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        
        keyList=new ArrayList(map.keySet());
        
        backTrack(ans,new ArrayList());
        
        return ans;
    }
}