class Solution {
    public List<String> letterCombinations(String digits) {
        
        //List<StringBuilder> strlist=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        Map<String,String[]> map=new HashMap<>();
        
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","h","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","r","s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});
        
        
        int n=digits.length();
        
        if(n==0)
            return ans;
        
        for(String s: map.get(digits.substring(0,1)))
            ans.add(s);
        
        for(int i=1;i<n;i++)
        {
            String[] temp=map.get(digits.substring(i,i+1));
            int m=temp.length;
            int p=ans.size();
            
            addElements(ans,m-1);
            
           // for(String s:ans)
                //System.out.println(s);
            
            for(int k=0;k<p;k++)
            {
                for(int j=0;j<m;j++)
                {
                    ans.set(k*m+j,ans.get(k*m+j)+temp[j]);
                }
            }
                    
        }
        
        //for(StringBuilder sb:strlist)
          //  ans.add(sb.toString());
        
        return ans;
    }
    
    private void addElements(List<String> list, int k)
    {
        int p=list.size();
        
        for(int i=1;i<=p;i++)
        {
            int j=(i-1)*(k+1);
            String s=list.get(j);
            
            for(int l=1;l<=k;l++)
                list.add(j,s);
        }
    }
}