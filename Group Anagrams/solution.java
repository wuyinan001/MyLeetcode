class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++)
        {
            String countcode=count(strs[i]);
            if(map.containsKey(countcode))
            {
                List<String> list=map.get(countcode);
                list.add(strs[i]);
                map.put(countcode,list);
            }
            else
            {
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                map.put(countcode,list);
            }
        }

        return new ArrayList<>(map.values());
    }
    
    private String count(String s)
    {
        int[] letters=new int[26];
        for(int i=0;i<s.length();i++)
        {
            letters[s.charAt(i)-'a']++;
        }
        
        StringBuilder sb=new StringBuilder("");
        
        for(int i=0;i<26;i++)
        {
            sb.append('#');
            sb.append(letters[i]);
        }
        
        return sb.toString();
    }
}