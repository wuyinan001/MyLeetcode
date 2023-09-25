class Solution:
    def missingNumber(self, arr: List[int]) -> int:
        n=len(arr)
        
        return int((n+1)*(arr[0]+arr[-1])/2)-sum(arr)