class Solution:
    def largestUniqueNumber(self, nums: List[int]) -> int:
        dict1={}
        for i in nums:
            dict1[i]=dict1.get(i,0)+1
        
        list1=list(dict1.keys())

        list1.sort(reverse=True)

        for i in list1:
            if dict1[i]==1:
                return i
        
        return -1