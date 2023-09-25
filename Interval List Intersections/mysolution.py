class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        list1=[]
        
        for interval in firstList:
            list1.append([interval[0],0,0])
            list1.append([interval[1],1,0])
            
        for interval in secondList:
            list1.append([interval[0],0,1])
            list1.append([interval[1],1,1])
        
        list1.sort(key=lambda x:(x[0],x[1]))
        
        ans=[]
        sum1=0
        n=len(list1)
        
        for i in range(n):
            if list1[i][1]==0:
                sum1+=1
            else:
                sum1-=1
            
            if sum1==2:
                ans.append([list1[i][0],list1[i+1][0]])
        
        return ans