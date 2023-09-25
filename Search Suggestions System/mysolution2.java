class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products, new Comparator<String>(){
            
            public int compare(String s1, String s2)
            {
                return s1.compareTo(s2);
            }
            
        });
        
        int n=searchWord.length(), m=products.length;
        
        List<List<String>> ans=new ArrayList();
        
        int lo=0,hi=m-1;
        
        for(int i=0;i<n;i++)
        {        
            List<String> list=new ArrayList();
            
            while(lo<m)
            {
                if(products[lo].length()>=(i+1)&&searchWord.charAt(i)==products[lo].charAt(i)) 
                    break;
                
                lo++;
            }
            
            while(hi>=0)
            {
                if(products[hi].length()>=(i+1)&&searchWord.charAt(i)==products[hi].charAt(i)) 
                    break;
                
                hi--;
            }
            
            for(int j=lo;j<=Math.min(hi,lo+2);j++)
                if(products[j].length()>=(i+1)&&searchWord.charAt(i)==products[j].charAt(i))
                    list.add(products[j]);
            
            ans.add(list);
        }
        
        
        return ans;
    }
}