class Solution {
    
    private boolean isSelfDividing(int n)
    {
        List<Integer> list=new ArrayList();
        int n2=n,k=0;
        
        while(n2>0)
        {
            k=n2%10;
            if(k==0)
                return false;
            list.add(k);
            n2=n2/10;
        }
        
        for(int i:list)
            if(n%i!=0)
                return false;
        
        return true;
    }
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> ans=new ArrayList();
        
        for(int k=left;k<=right;k++)
        {
            if(isSelfDividing(k))
                ans.add(k);
        }
        
        return ans;
    }
}