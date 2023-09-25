class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set=new HashSet();
        
        for(String s:emails)
        {
            String[] strs=s.split("@");
            
            StringBuilder sb=new StringBuilder();
            
            for(int i=0;i<strs[0].length();i++)
            {
                char c=strs[0].charAt(i);
                
                if(c=='+')
                    break;
                else if(c=='.')
                    continue;
                else
                    sb.append(c);
            }
            
            sb.append("@"+strs[1]);
            
            set.add(sb.toString());
        }
        
        return set.size();
        
    }
}