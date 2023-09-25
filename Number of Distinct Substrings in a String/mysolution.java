class Solution {
    public int countDistinct(String s) {
        
        int n=s.length();
        
        Set<String> set=new HashSet();
        
        for(int gap=0;gap<=n-1;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                
                if(!set.contains(s.substring(i,j+1)))
                    set.add(s.substring(i,j+1));
            }
        }
        
        return set.size();
        
    }
}