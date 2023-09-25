class Solution:    
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        ans=set([i for i in range(n)])
        
        for u,v in edges:
            if v in ans:
                ans.remove(v)
        
        return ans