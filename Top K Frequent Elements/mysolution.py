class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq={}
        for i in nums:
            if i not in freq.keys():
                freq[i]=1
            else:
                freq[i]+=1
        
        ans=list(freq.keys())
        ans.sort(key=lambda x:-freq[x])
        
        return ans[0:k]