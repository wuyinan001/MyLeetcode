from collections import defaultdict

class Solution:
    def findShortest(self,index,list1,lo,hi):
        if lo==hi:
            return abs(list1[lo]-index)
        
        mid=(lo+hi)//2

        if list1[mid]<index and list1[mid+1]<index:
            return self.findShortest(index,list1,mid+1,hi)
        elif list1[mid]>index and list1[mid+1]>index:
            return self.findShortest(index,list1,lo,mid)
        else:
            return min(abs(list1[mid]-index),abs(list1[mid+1]-index))

    def shortestDistanceColor(self, colors: List[int], queries: List[List[int]]) -> List[int]:
        dict1=defaultdict(list)
        n=len(colors)

        for i in range(n):
            dict1[colors[i]].append(i)
        
        m=len(queries)

        ans=[float('inf') for i in range(m)]

        for i in range(m):
            if queries[i][1] not in dict1:
                ans[i]=-1
                continue

            ans[i]=self.findShortest(queries[i][0],dict1[queries[i][1]],0,len(dict1[queries[i][1]])-1)

        return ans