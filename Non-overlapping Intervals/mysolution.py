class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0])
        n=len(intervals)
        # L:max num of intervals to keep without overlap
        L=1
        # the prev interval to keep
        prev=intervals[0]
        
        for i in range(1,n):
            if intervals[i][0]>=prev[1]:
                L+=1
                prev=intervals[i]
            elif intervals[i][1]<=prev[1]:
                prev=intervals[i]
            else:
                continue
        
        return n-L