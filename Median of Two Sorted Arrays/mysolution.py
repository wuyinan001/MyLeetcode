class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1=len(nums1)
        n2=len(nums2)
        
        i=0
        j=0
        
        a=-1
        b=-1
        
        if (n1+n2)%2==0:
            for k in range((n1+n2)//2+1):
                if i==n1:
                    if k==(n1+n2)//2-1:
                        a=nums2[j]
                    elif k==(n1+n2)//2:
                        b=nums2[j]
                    j+=1
                elif j==n2:
                    
                    if k==(n1+n2)//2-1:
                        a=nums1[i]
                    elif k==(n1+n2)//2:
                        b=nums1[i]
                    i+=1
                elif nums1[i]<=nums2[j]:
                    
                    if k==(n1+n2)//2-1:
                        a=nums1[i]
                    elif k==(n1+n2)//2:
                        b=nums1[i]
                    i+=1
                else:
                    
                    if k==(n1+n2)//2-1:
                        a=nums2[j]
                    elif k==(n1+n2)//2:
                        b=nums2[j]
                    j+=1
            return (a+b)/2
        else:
            for k in range((n1+n2)//2+1):
                if i==n1:
                    if k==(n1+n2)//2:
                        return nums2[j]*1.0
                    j+=1
                elif j==n2:
                    if k==(n1+n2)//2:
                        return nums1[i]*1.0
                    i+=1
                elif nums1[i]<=nums2[j]:
                    if k==(n1+n2)//2:
                        return nums1[i]*1.0
                    i+=1
                else:
                    if k==(n1+n2)//2:
                        return nums2[j]*1.0
                    j+=1