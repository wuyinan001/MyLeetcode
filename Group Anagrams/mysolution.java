class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        
        for(String str:strs)
        {
            String sort_str=sort(str);
            
            if(!map.containsKey(sort_str))
            {
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(sort_str,list);
            }
            else
                map.get(sort_str).add(str);
        }
        
        for(String key:map.keySet())
        {
            ans.add(map.get(key));
        }
        
        return ans;
        
    }
    
    private String sort(String str)
    {
        char[] array=str.toCharArray();
        
        Arrays.sort(array);
        
        return new String(array);
    }
    
}