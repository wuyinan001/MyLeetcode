class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        map1={}
        n=len(s)
        
        for i in range(n):
            map1[s[i]]=i
        
        ans=[]
        
        index=0
        
        while index<n:
            last_index=map1[s[index]]
            i=index+1
            while i<=last_index:
                last_index=max(last_index,map1[s[i]])
                i+=1
            ans.append(last_index-index+1)
            index=last_index+1
        
        return ans