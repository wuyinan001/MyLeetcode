class Solution {
    
    public List<String> findStrobogrammatic(int n) {
        
        if(n==1)
            return Arrays.asList("0","1","8");
        else if(n==2)
            return Arrays.asList("11","69","96","88");
        else
        {
            
            List<String> ans=new ArrayList();
            if(n%2==0)
            {
                List<String> list=findStrobogrammatic(n-2);
                for(String s:list)
                {
                    ans.add(s.substring(0,(n-2)/2)+"00"+s.substring((n-2)/2));
                    ans.add(s.substring(0,(n-2)/2)+"11"+s.substring((n-2)/2));
                    ans.add(s.substring(0,(n-2)/2)+"69"+s.substring((n-2)/2));
                    ans.add(s.substring(0,(n-2)/2)+"96"+s.substring((n-2)/2));
                    ans.add(s.substring(0,(n-2)/2)+"88"+s.substring((n-2)/2));
                }
                
            }
            else
            {
                List<String> list=findStrobogrammatic(n-1);
                for(String s:list)
                {
                    ans.add(s.substring(0,(n-1)/2)+"0"+s.substring((n-1)/2));
                    ans.add(s.substring(0,(n-1)/2)+"1"+s.substring((n-1)/2));
                    ans.add(s.substring(0,(n-1)/2)+"8"+s.substring((n-1)/2));
                }
            }
            
            return ans;
        }
        
        
    }
}