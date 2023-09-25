class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n=A.length;
        
        int i=0,j=1;
        
        while(i<n&&j<n)
        {
            while(A[i]%2==0)
            {
                i+=2;
                if(i>n-1)
                    return A;
            }
            
            while(A[j]%2!=0)
            {
                j+=2;
                if(j>n-1)
                    return A;
            }
            
            exchange(A,i,j);
            i+=2;
            j+=2;
        }
        
        return A;
    }
    
    private void exchange(int[] a, int i, int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}