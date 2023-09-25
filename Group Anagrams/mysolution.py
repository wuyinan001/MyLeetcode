class Solution:
    
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        Dict={}
        
        for s in strs:
            key=''.join(sorted(s))
            
            if not key in Dict.keys():
                Dict[key]=[s]
            else:
                Dict[key].append(s)
        
        ans=[]
        
        for key in Dict.keys():
            ans.append(Dict[key])
        
        return ans