class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        ans=[]
        freq={}
        
        for i in nums:
            freq[i]=freq.get(i,0)+1
            
        empty=0
        
        while len(freq)>empty:
            curr=[]
            for key in freq:
                if freq[key]>0:
                    if freq[key]==1:
                        empty+=1
                    curr.append(key)
                    freq[key]-=1
            ans.append(curr)
        
        return ans