class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] aux=new int[m];
        
        for(int k=0;k<m;k++)
            aux[k]=nums1[k];
        
        int i=0,j=0;
        
        for(int k=0;k<m+n;k++)
        {
            if(i>=m)
                nums1[k]=nums2[j++];
            else if(j>=n)
                nums1[k]=aux[i++];
            else if(aux[i]<nums2[j])
                nums1[k]=aux[i++];
            else
                nums1[k]=nums2[j++];
        }
    }
}