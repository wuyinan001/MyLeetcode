class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        dict1={}
        n=len(names)
        index=[i for i in range(n)]
        
        index.sort(key=lambda x:heights[x],reverse=True)
        
        ans=[]
        
        for i in index:
            ans.append(names[i])
            
        return ans