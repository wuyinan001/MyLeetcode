class Solution {
    
    /* This problem can be reduced to find the max and min diff of the following four arrays:
        
        1. arr1[i]+arr2[i]+i
        2. arr1[i]+arr2[i]-i
        3. arr1[i]-arr2[i]+i
        4. arr1[i]-arr2[i]-i
    */
    
    private int maxDiff(int[] arr)
    {
        int max=arr[0], min=arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        
        return max-min;
    }
    
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int n=arr1.length;
        
        int[] a1=new int[n], a2=new int[n], a3=new int[n], a4=new int[n];
        
        for(int i=0;i<n;i++)
        {
            a1[i]=arr1[i]+arr2[i]+i;
            a2[i]=arr1[i]+arr2[i]-i;
            a3[i]=arr1[i]-arr2[i]+i;
            a4[i]=arr1[i]-arr2[i]-i;
        }
        
        return Math.max(Math.max(maxDiff(a1),maxDiff(a2)),Math.max(maxDiff(a3),maxDiff(a4)));
    }
}