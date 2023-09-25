class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        
        int n=citations.length;
        
        for(int i=n-1;i>=0;i--)
        {
            if(citations[i]<n-i)
                return n-i-1;
        }
        
        return n;
    }
}