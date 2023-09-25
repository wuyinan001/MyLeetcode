class Solution:
    def splitPainting(self, segments: List[List[int]]) -> List[List[int]]:
        endpoints=[]
        
        for seg in segments:
            endpoints.append([seg[0],seg[2]])
            endpoints.append([seg[1],-seg[2]])
        
        endpoints.sort(key=lambda x:x[0])
        
        sum1=endpoints[0][1]
        ans=[]  
    
        for i in range(1,len(endpoints)):
            if endpoints[i][0]!=endpoints[i-1][0] and sum1!=0:
                ans.append([endpoints[i-1][0],endpoints[i][0],sum1])
            sum1+=endpoints[i][1]
        
        return ans