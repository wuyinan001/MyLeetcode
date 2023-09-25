class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans=new LinkedList<>();
        
        if(strs.length==0)
            return ans;
        
        for(int i=0;i<strs.length;i++)
        {
            boolean find=false;
            for(int j=0;j<ans.size();j++)
            {
                if(isPermutation(ans.get(j).get(0),strs[i]))
                {
                    find=true;
                    ans.get(j).add(strs[i]);
                    break;
                }
            }
            
            if(!find)
            {
                List<String> list=new LinkedList<>();
                list.add(strs[i]);
                ans.add(list);
            }
            
        }
        return ans;
    }
    
    private boolean isPermutation(String s1, String s2)
    {
        if(s1.length()!=s2.length())
            return false;
        
        int[] letters=new int[26];
        
        for(int i=0;i<s1.length();i++)
        {
            int c=s1.charAt(i)-'a';
            letters[c]++;
        }
        
        for(int i=0;i<s2.length();i++)
        {
            int c=s2.charAt(i)-'a';
            letters[c]--;
            if(letters[c]<0)
                return false;
        }
        
        return  true;
    }
}