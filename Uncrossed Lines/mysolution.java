class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int n1=nums1.length, n2=nums2.length;
        
        int[][] L=new int[n1+1][n2+1];
        
        for(int i=1;i<=n1;i++)
        {
            for(int j=1;j<=n2;j++)
            {
                if(nums1[i-1]==nums2[j-1])
                    L[i][j]=1+L[i-1][j-1];
                else
                    L[i][j]=Math.max(L[i-1][j],L[i][j-1]);
            }
        }
        
        return L[n1][n2];
    }
}