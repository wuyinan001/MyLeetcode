class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> ans=new ArrayList();
        
        Arrays.sort(products);
        
        int n=searchWord.length(), m=products.length;
        int start=0, end=m-1;
        
        for(int i=0;i<n;i++)
        {
            List<String> list=new ArrayList();
            
            if(start>=m||end<0||start>end)
            {
                ans.add(list);
                continue;
            }
            
            String prefix=searchWord.substring(0,i+1);
            
            while(start<m&&((products[start].length()<i+1)||(!products[start].substring(0,i+1).equals(prefix))))
                start++;
            
            while(end>=0&&((products[end].length()<i+1)||(!products[end].substring(0,i+1).equals(prefix))))
                end--;
            
            
            
            for(int j=start;j<=Math.min(start+2,end);j++)
                list.add(products[j]);
            
            ans.add(list);
        }
        
        return ans;
    }
}