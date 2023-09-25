import heapq

class MedianFinder:

    def __init__(self):
        self.pq1=[]
        self.pq2=[]
        # pq1: max pq; pq2: min pq
        heapq.heapify(self.pq1)
        heapq.heapify(self.pq2)
        

    def addNum(self, num: int) -> None:
        heapq.heappush(self.pq2,num)
        heapq.heappush(self.pq1,-heapq.heappop(self.pq2))
        if len(self.pq1)>1+len(self.pq2):
            heapq.heappush(self.pq2,-heapq.heappop(self.pq1))
        

    def findMedian(self) -> float:
        if len(self.pq1)==len(self.pq2):
            return (-self.pq1[0]+self.pq2[0])/2.0
        else:
            return -1.0*self.pq1[0]


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()