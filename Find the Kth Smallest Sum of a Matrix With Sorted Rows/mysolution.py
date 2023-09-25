import heapq

class Solution:
    def addToHeap(self,mat,row,val,k,maxPQ):
        for i in range(len(mat[0])):
            heapq.heappush(maxPQ,-(val+mat[row][i]))
            if len(maxPQ)>k:
                heapq.heappop(maxPQ)
    
    def createPQ(self,mat,row,k,maxPQ):
        pq=[]
        heapq.heapify(pq)
        
        while maxPQ:
            self.addToHeap(mat,row,-heapq.heappop(maxPQ),k,pq)
        
        return pq
        
    def kthSmallest(self, mat: List[List[int]], k: int) -> int:
        maxPQ=[]
        heapq.heapify(maxPQ)
        self.addToHeap(mat,0,0,k,maxPQ)
        
        for row in range(1,len(mat)):
            maxPQ=self.createPQ(mat,row,k,maxPQ)
        
        return -maxPQ[0]