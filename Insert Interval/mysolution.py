class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans=[]
        inserted=False
        
        for interval in intervals:
            if not inserted and newInterval[0]<=interval[0]:
                if not ans or ans[-1][1]<newInterval[0]:
                    ans.append(newInterval)
                else:
                    ans[-1][1]=max(ans[-1][1],newInterval[1])
                
                inserted=True
            
            if not ans or ans[-1][1]<interval[0]:
                ans.append(interval)
            else:
                ans[-1][1]=max(ans[-1][1],interval[1])
        
        if not inserted:
            if not ans or ans[-1][1]<newInterval[0]:
                ans.append(newInterval)
            else:
                ans[-1][1]=max(ans[-1][1],newInterval[1])
        
        return ans