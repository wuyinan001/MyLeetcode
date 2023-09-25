class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        if len(arr)<3:
            return False
        # if mode=0: start
        # mode=1: up
        # mode=2: down
        mode=0

        n=len(arr)

        for i in range(1,n):
            if arr[i]==arr[i-1]:
                return False
            if mode==0:
                if arr[i]<arr[i-1]:
                    return False
                else:
                    mode=1
            elif mode==1:
                if arr[i]<arr[i-1]:
                    mode=2
            else:
                if arr[i]>arr[i-1]:
                    return False
        
        return mode==2
