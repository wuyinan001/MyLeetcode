class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        n=len(nums)
        # P[i]: the presum of nums at index i-1
        P=[0 for i in range(n+1)]
        # monoqueue: the index(staring at 1) of nums; the P[monoqueue[i]] increases with i
        monoqueue=[]

        for i in range(n):
            P[i+1]=P[i]+nums[i]

        ans=n+1

        for i,Pi in enumerate(P):
            # If P[j]-P[monoqueue[-1]]>=k, j-monoqueue[-1] won't be the shortest subarray
            # because P[j]-P[i]>k and j-i<j-monoqueue[-1]
            while monoqueue and Pi<=P[monoqueue[-1]]:
                monoqueue.pop()
            
            # If P[i]-P[monoqueue[0]]>=k, then the subarray starting at monoqueue[0]
            # that meets P[j]-P[monoqueue[0]]>=k for j>i won't be the shortest
            # So pop monoqueue[0] after checking i
            while monoqueue and Pi-P[monoqueue[0]]>=k:
                ans=min(ans,i-monoqueue.pop(0))
            
            monoqueue.append(i)
        
        return ans if ans<=n else -1