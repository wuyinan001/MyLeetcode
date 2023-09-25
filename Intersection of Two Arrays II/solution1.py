class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if len(nums1)==0 or len(nums2)==0:
            return []
        
        result=[]
        
        nums1.sort()
        nums2.sort()
        
        n1=len(nums1)
        n2=len(nums2)
        
        i=0
        j=0
        
        while i<n1 and j<n2:
            if nums1[i]==nums2[j]:
                result.append(nums1[i])
                i=i+1
                j=j+1
            elif nums1[i]<nums2[j]:
                i=i+1
            else:
                j=j+1
        
        return result