class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> ans=new ArrayList();
        
        int n=s.length(), start=0, count=1;
        
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)!=s.charAt(i-1))
            {
                if(count>=3)
                {
                    List<Integer> list=new ArrayList();
                    list.add(start);
                    list.add(i-1);
                    ans.add(list);
                }
                count=1;
                start=i;
            }
            else
            {
                count++;
            }
        }
        
        if(count>=3)
        {
            List<Integer> list=new ArrayList();
            list.add(start);
            list.add(n-1);
            ans.add(list);
        }
        
        return ans;
    }
}