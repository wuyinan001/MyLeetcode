class Solution:
    def canConvert(self, str1: str, str2: str) -> bool:
        map1={}
        set1=set([])
        n=len(str1)
        
        for i in range(n):
            if str1[i] in map1.keys() and map1[str1[i]]!=str2[i]:
                return False
            
            map1[str1[i]]=str2[i]
            set1.add(str2[i])
        
        if len(map1)==26 and len(set1)==26 and str1!=str2:
            return False
        else:
            return True