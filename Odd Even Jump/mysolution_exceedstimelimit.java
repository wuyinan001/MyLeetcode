class Solution {
    public int oddEvenJumps(int[] A) {
        
        int n=A.length;
        
        if(n==0)
            return 0;
        
        if(n==1)
            return 1;
        
        // L[i][0]: whether it is possible to odd jump from i to the end
        // L[i][1]: whether it is possible to even jump from i to the end
        boolean[][] L=new boolean[n][2];
        // oddnext[i]: which index to get if odd jump from i; -1 if not exist
        int[] oddnext=new int[n];
        // evennext[i]: which index to get if even jump from i; -1 if not exist
        int[] evennext=new int[n];
        
        for(int i=0;i<n;i++)
        {
            oddnext[i]=-1;
            evennext[i]=-1;
        }
        
        for(int i=n-2;i>=0;i--)
        {
            int min=200000;
            int max=-1;
            for(int j=i+1;j<n;j++)
            {
                if(A[j]>=A[i]&&A[j]<min)
                {
                    min=A[j];
                    oddnext[i]=j;
                }
                
                if(A[j]<=A[i]&&A[j]>max)
                {
                    max=A[j];
                    evennext[i]=j;
                }
            }
        }
        
        //print(oddnext);
        //print(evennext);
        
        L[n-1][0]=true;
        L[n-1][1]=true;
        
        int count=1;
        
        for(int i=n-2;i>=0;i--)
        {
            //Check if odd jump can get to the end
            if(oddnext[i]!=-1&&L[oddnext[i]][1])
                L[i][0]=true;
            
            //Check if even jump can get to the end
            if(evennext[i]!=-1&&L[evennext[i]][0])
                L[i][1]=true;
            
            if(L[i][0])
                count++;
        }
        
        return count;
    }
    
    private void print(int[] a)
    {
        int n=a.length;

        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}