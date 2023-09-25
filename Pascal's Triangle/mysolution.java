class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=1;i<=numRows;i++)
        {
            List<Integer> list=new ArrayList<>();
            
            list.add(1);
            
            if(i!=1)
            {
                List<Integer> temp=ans.get(i-2);
                
                for(int j=1;j<temp.size();j++)
                {
                    list.add(temp.get(j)+temp.get(j-1));
                }
                
                list.add(1);
            }
            
            ans.add(list);
        }
        
        return ans;
    }
    
    
}