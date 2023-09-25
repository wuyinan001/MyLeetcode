class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        n=len(arr)

        min_d=arr[n-1]-arr[0]

        for i in range(n-1):
            min_d=min(min_d,arr[i+1]-arr[i])
        
        ans=[]

        for i in range(n-1):
            if arr[i+1]-arr[i]==min_d:
                ans.append([arr[i],arr[i+1]])

        return ans