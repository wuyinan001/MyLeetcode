class Solution:
    def countElements(self, arr: List[int]) -> int:
        dict1={}
        
        for i in arr:
            dict1[i]=dict1.get(i,0)+1
        
        ans=0
        
        for key in dict1:
            if key+1 in dict1:
                ans+=dict1[key]
        
        return ans