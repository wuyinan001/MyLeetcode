import heapq

class Solution:
    def enqueue(self,pq1,pq2,num):
        if len(pq1)==len(pq2):
            heapq.heappush(pq2,num)
            heapq.heappush(pq1,-heapq.heappop(pq2))
        else:
            heapq.heappush(pq1,-num)
            heapq.heappush(pq2,-heapq.heappop(pq1))
            
    def remove(self,pq1,pq2,num):
        if len(pq1)==len(pq2):
            ans=(-pq1[0]+pq2[0])/2.0
            if num<=-pq1[0]:
                pq1.remove(-num)
                heapq.heapify(pq1)
                heapq.heappush(pq1,-heapq.heappop(pq2))
            else:
                pq2.remove(num)
                heapq.heapify(pq2)
        else:
            ans=-pq1[0]*1.0
            if num<=-pq1[0]:
                pq1.remove(-num)
                heapq.heapify(pq1)
            else:
                pq2.remove(num)
                heapq.heapify(pq2)
                heapq.heappush(pq2,-heapq.heappop(pq1))
                
        return ans

    
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        pq1=[]
        pq2=[]
        
        heapq.heapify(pq1)
        heapq.heapify(pq2)
        
        ans=[]
        
        n=len(nums)
        
        for i in range(k):
            self.enqueue(pq1,pq2,nums[i])
            
        for i in range(k,n):
            ans.append(self.remove(pq1,pq2,nums[i-k]))
            self.enqueue(pq1,pq2,nums[i])
            
        ans.append(self.remove(pq1,pq2,nums[n-k]))
        return ans