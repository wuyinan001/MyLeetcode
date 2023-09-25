class Solution(object):
    def lenLongestFibSubseq(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        n=len(A)
        
        if n<=2:
            return 0
        
        L=[]
        C=[]
        
        L.append([1])
        L.append([1])
        
        C.append([0])
        C.append([0])
        
        max_l=1
        
        for i in range(2,n):
            two_sum=self.findTwoSum(A,0,i-1,A[i])
            
            if two_sum==[]:
                L.append([1])
                C.append([0])
            else:
                #max_l=3
                l=[]
                c=[]
                
                for t in two_sum:                    
                    
                    m=len(L[t])
                    for j in range(m):
                        if C[t][j]==A[i]:
                            l.append(L[t][j]+1)
                            c.append(A[i]+A[t])
                        else:
                            l.append(3)
                            c.append(A[i]+A[t])
                        
                        if max_l<l[-1]:
                            max_l=l[-1]
                    
                
                #print(l)
                #print(c)
                
                L.append(l)
                C.append(c)
        
        print(L)
        print(C)

        if max_l<3:
            max_l=0
        
        return max_l
        
    # Return the index of second num in all pairs that sum to key
    def findTwoSum(self,A,lo,hi,key):
        
        result=[]
        
        for i in range(lo,hi+1):
            for j in range(i+1,hi+1):
                if A[i]+A[j]==key:
                    result.append(j)
        
        return result