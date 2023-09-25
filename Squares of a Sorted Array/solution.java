class Solution {
    public int[] sortedSquares(int[] A) {
        int n=A.length;
        
        int[] result=new int[n];
        
        int min_sqindex=0;
            
        while(min_sqindex<n-1)
        {
            if(Math.abs(A[min_sqindex])<Math.abs(A[min_sqindex+1]))
                break;
            min_sqindex++;
        }
        
        int i=min_sqindex-1,j=min_sqindex+1;
        
        result[0]=(int)Math.pow(A[min_sqindex],2);
        
        int count=0;
        
        while(count<n-1)
        {
            count++;
            
            if(i<0)
                result[count]=(int)Math.pow(A[j++],2);
            else if(j>=n)
                result[count]=(int)Math.pow(A[i--],2);
            else if(Math.abs(A[i])<Math.abs(A[j]))
                result[count]=(int)Math.pow(A[i--],2);
            else
                result[count]=(int)Math.pow(A[j++],2);
        }
        
        return result;
    }
}