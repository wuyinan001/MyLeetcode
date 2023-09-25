class Solution {
    public double trimMean(int[] arr) {
        
        Arrays.sort(arr);
        
        int n=arr.length;
        
        int sum=0;
        
        int lo=(int)(n*0.05), hi=(int)(n*0.95);
        
        //System.out.println(lo+":"+hi+":"+n);
        
        for(int i=lo;i<hi;i++)
        {
            sum+=arr[i];
        }
        
        return (double)(sum)/(hi-lo);
    }
}