class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        freq={}

        for i in nums:
            freq[i]=freq.get(i,0)+1
        
        list1=list(freq.keys())

        list1.sort(key=lambda x:[freq[x],-x])

        ans=[]

        for key in list1:
            for _ in range(freq[key]):
                ans.append(key)

        return ans