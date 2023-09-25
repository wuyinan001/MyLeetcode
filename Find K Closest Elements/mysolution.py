class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        ans=[]

        n=len(arr)
        min_index=-1
        min_d=float('inf')

        for i in range(n):
            if min_d>abs(arr[i]-x):
                min_d=abs(arr[i]-x)
                min_index=i
        
        ans.append(arr[min_index])

        k-=1

        i=min_index-1
        j=min_index+1

        while k>0:
            if i==-1:
                ans.append(arr[j])
                j+=1
            elif j==n:
                ans.insert(0,arr[i])
                i-=1
            elif abs(arr[i]-x)<=abs(arr[j]-x):
                ans.insert(0,arr[i])
                i-=1
            else:
                ans.append(arr[j])
                j+=1
            k-=1

        return ans