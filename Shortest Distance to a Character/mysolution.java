class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int n=s.length();
        
        int[] ans=new int[n];
        
        Set<Integer> set=new HashSet();
        
        for(int i=0;i<n;i++)
            if(s.charAt(i)==c)
                set.add(i);
        
        int dist=0;
        
        for(int i=0;i<n;i++)
        {
            dist=0;
            while(!set.contains(i+dist)&&!set.contains(i-dist))
            {
                dist++;
            }
            
            ans[i]=dist;
        }
        
        return ans;
    }
}