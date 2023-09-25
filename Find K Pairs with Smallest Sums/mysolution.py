import heapq

class Pair:
    def __init__(self,v1,v2,index2):
        self.v1=v1
        self.v2=v2
        self.index2=index2
    
    def __lt__(self,other):
        return (self.v1+self.v2)<(other.v1+other.v2)
    
    def __repr__(self):
        return "({},{},{})".format(self.v1,self.v2,self.index2)
    
class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        ans=[]
        n1=len(nums1)
        n2=len(nums2)
        pq=[]
        heapq.heapify(pq)
        
        for i in range(min(k,n1)):
            heapq.heappush(pq,Pair(nums1[i],nums2[0],0))
        
        
        while pq:
            if len(ans)==k:
                return ans
            
            pair=heapq.heappop(pq)
            #print(pair)
            ans.append([pair.v1,pair.v2])
            if pair.index2<n2-1:
                heapq.heappush(pq,Pair(pair.v1,nums2[pair.index2+1],pair.index2+1))
        
        return ans