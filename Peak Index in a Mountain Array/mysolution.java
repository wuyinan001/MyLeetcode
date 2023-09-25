class Solution {
    
    private int binary(int[] arr, int lo, int hi)
    {
        if(lo==hi)
            return lo;
        
        int mid=lo+(hi-lo)/2;
        
        if(arr[mid]<arr[mid+1])
            return binary(arr,mid+1,hi);
        else
            return binary(arr,lo,mid);
    }
    
    public int peakIndexInMountainArray(int[] arr) {
        
        return binary(arr,0,arr.length-1);
    }
}