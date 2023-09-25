class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        n=len(colors)
        
        ans=0
        
        # We can keep only one ballon in each same color section and keep the one that
        # has maximum neededTime to minimize the total time of removing ballons
        
        # sum1: The total neededTime in current same color section
        sum1=0
        # max1: The max neededTime in current same color section
        max1=0
        # count: The total number of balloons in current same color section
        count=0
        
        
        
        for i in range(n):
            if i>0 and colors[i]!=colors[i-1]:
                if count>1:
                    ans+=sum1-max1
                count=1
                sum1=neededTime[i]
                max1=neededTime[i]
            else:
                sum1+=neededTime[i]
                count+=1
                max1=max(max1,neededTime[i])
        
        if count>1:
            ans+=sum1-max1
        
        return ans