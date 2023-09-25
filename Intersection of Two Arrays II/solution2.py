class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        result=[]
        
        for i in range(len(nums2)):
            if nums2[i] in nums1:
                result.append(nums2[i])
                nums1.remove(nums2[i])
        
        return result