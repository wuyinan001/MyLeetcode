class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        # L[i] holds all combinations to get target i
        L=[]
        
        for i in range(1,target+1):
            L.append([])
            for a in candidates:
                if a==i:
                    L[i-1].append([a])
                elif a<i:
                    if(len(L[i-a-1])!=0):
                        n=len(L[i-a-1])
                        for j in range(n):
                            L[i-1].append([a]+L[i-a-1][j])
            
        # remove dupicate combinations
        result=[]
        
        n=len(L[target-1])
        
        for i in range(n):
            L[target-1][i].sort()
            #print(L[target-1][i])
            if L[target-1][i] not in result:
                result.append(L[target-1][i])
            
        return result