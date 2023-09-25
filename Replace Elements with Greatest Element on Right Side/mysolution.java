class Solution {
    public int[] replaceElements(int[] arr) {
        
        int n=arr.length;
        int max=arr[n-1];
        int cache;
        arr[n-1]=-1;
        
        for(int i=n-2;i>=0;i--)
        {
            cache=arr[i];
            arr[i]=max;
            max=Math.max(max,cache);
        }
        
        return arr;
    }
}