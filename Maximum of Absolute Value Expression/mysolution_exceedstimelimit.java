class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int max=0;
        
        int n=arr1.length;
        
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
            {
                max=Math.max(max,Math.abs(arr1[i]-arr1[j])+Math.abs(arr2[i]-arr2[j])+Math.abs(i-j));
            }
        
        return max;
    }
}