class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        
        int i=0,j=0;
        int result=0;
        
        if((n1+n2)%2!=0)
        {
            for(int k=1;k<=(n1+n2)/2+1;k++)
            {
                if(i>=n1)
                    result=nums2[j++];
                else if(j>=n2)
                    result=nums1[i++];
                else if(nums1[i]<nums2[j])
                    result=nums1[i++];
                else
                    result=nums2[j++];
                
                if(k==(n1+n2)/2+1)
                {
                    return result;
                }
            }
        }
        else
        {
            for(int k=1;k<=(n1+n2)/2+1;k++)
            {
                if(i>=n1)
                    result=nums2[j++];
                else if(j>=n2)
                    result=nums1[i++];
                else if(nums1[i]<nums2[j])
                    result=nums1[i++];
                else
                    result=nums2[j++];
                
                if(k==(n1+n2)/2)
                {
                    if(i>=n1)
                        result=result+nums2[j];
                    else if(j>=n2)
                        result=result+nums1[i];
                    else
                        result=result+Math.min(nums1[i],nums2[j]);
                    
                    return result/2.0;
                }
            }
        }
        
        return result;
    }
}