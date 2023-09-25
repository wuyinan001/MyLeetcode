class Solution {
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]==0)
            {
                for(int j=n-1;j>=i+2;j--)
                {
                    arr[j]=arr[j-1];
                }
                
                arr[++i]=0;
            }
        }
    }
}