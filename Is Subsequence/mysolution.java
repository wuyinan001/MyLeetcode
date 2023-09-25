class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=t.length();
        int m=s.length();
        
        if(m==0)
            return true;
        
        if(n==0)
            return false;
        
        // L contains number of matches at t substring ending at i
        int[] L=new int[n];
        
        if(t.substring(0,1).equals(s.substring(0,1)))
                L[0]=1;
        else
                L[0]=0;
    
        
        for(int i=1;i<n;i++)
        {
            if(t.substring(i,i+1).equals(s.substring(L[i-1],L[i-1]+1)))
                L[i]=L[i-1]+1;
            else
                L[i]=L[i-1];
            
            //System.out.println("L"+i+":"+L[i]);
            
            if(L[i]==m)
                return true;
        }
        
        return false;
    }
}