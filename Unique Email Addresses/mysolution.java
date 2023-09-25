class Solution {
    public int numUniqueEmails(String[] emails) {
        
        int n=emails.length;
        String[] local=new String[n];
        String[] domain=new String[n];
        HashMap<String,HashSet<String>> domain_map=new HashMap<>();
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            String[] results=emails[i].split("@");
            local[i]=results[0];
            domain[i]=results[1];
        }
        
        for(int i=0;i<n;i++)
        {
            if(!domain_map.containsKey(domain[i]))
            {
                ans++;
                HashSet<String> set=new HashSet<>();
                local[i]=convert(local[i]);
                set.add(local[i]);
                domain_map.put(domain[i],set);
            }
            else
            {
                HashSet<String> set=domain_map.get(domain[i]);
                local[i]=convert(local[i]);
                if(!set.contains(local[i]))
                {
                    ans++;
                    set.add(local[i]);
                    domain_map.put(domain[i],set);
                }
            }
        }
        
        return ans;
    }
    
    private String convert(String s)
    {
        String newStr=s.replace(".","");
        int n=newStr.length();
        // first '+' location
        int plus=n;

        for(int i=0;i<n;i++)
            if(newStr.charAt(i)=='+')
            {
                plus=i;
                break;
            }

        return newStr.substring(0,plus);
    }
}