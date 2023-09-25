class Solution {
    
    private void exchange(int[] arr, int i, int j)
    {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    
    public int[] prevPermOpt1(int[] arr) {
        
        // Find the last index that have smaller values after that index
        int n=arr.length;
        int i=n-1;
        
        while(i>=1)
        {
            if(arr[i-1]>arr[i])
                break;
            
            i--;
        }
        
        if(i==0)
            return  arr;
        
        i--;
        
        // Find the index of largest number that is smaller than arr[i] after i, if there are more than one then find the smallest index
        int max_index=i+1;
        
        int max=arr[max_index];
        
        for(int j=max_index+1;j<n;j++)
        {
            if(max<arr[j]&&arr[j]<arr[i])
            {
                max=arr[j];
                max_index=j;
            }
        }
        
        exchange(arr,i,max_index);
        
        return arr;
    }
}