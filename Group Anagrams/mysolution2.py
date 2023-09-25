class Solution:
    
    def toSorted(self,str1):
        return ''.join(sorted(str1))
    
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map1={}
        ans=[]
        
        for str1 in strs:
            str_sorted=self.toSorted(str1)
            if str_sorted not in map1:
                map1[str_sorted]=[]
            
            map1[str_sorted].append(str1)
        
        for key in map1.keys():
            ans.append(map1[key])
        
        return ans