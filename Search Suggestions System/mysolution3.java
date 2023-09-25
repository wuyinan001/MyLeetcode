class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> ans=new ArrayList();
        
        Arrays.sort(products);
        
        int i=0,j=products.length-1;
        
        for(int k=0;k<searchWord.length();k++)
        {
            List<String> list=new ArrayList();
            
            char c=searchWord.charAt(k);
            
            while(i<=j&&(products[i].length()<k+1||products[i].charAt(k)!=c))
            {
                i++;
            }
            
            while(j>=i&&(products[j].length()<k+1||products[j].charAt(k)!=c))
            {
                j--;
            }
            
            for(int r=i;r<=j;r++)
            {
                if(r==i+3)
                    break;
                list.add(products[r]);
            }
            
            ans.add(list);
        }
        
        return ans;
    }
}