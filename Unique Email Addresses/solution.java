class Solution {
    public int numUniqueEmails(String[] emails) {
        
        int n=emails.length;
        Set<String> set=new HashSet<>();
        
        for(int i=0;i<n;i++)
        {
            int j=emails[i].indexOf("@");
            
            String local=emails[i].substring(0,j);
            String domain=emails[i].substring(j);
            
            local=local.replace(".","");
            
            if(local.contains("+"))
                local=local.substring(0,local.indexOf("+"));
            
            set.add(local+domain);
        }
        
        return set.size();
    }
}