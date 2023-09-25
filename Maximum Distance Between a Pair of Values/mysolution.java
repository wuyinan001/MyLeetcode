class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int max=0;
        
        int n1=nums1.length, n2=nums2.length;
        
        int i=0,j=0;
        
        while(i<n1&&j<n2)
        {
            while(i<n1&&j<n2&&nums1[i]<=nums2[j])
                j++;
            
            max=Math.max(max,j-1-i);
            
            while(i<n1&&j<n2&&nums1[i]>nums2[j])
                i++;
        }
        
        return max;
    }
}