class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words=s.split(" ")
        if len(words)!=len(pattern):
            return False
        
        n=len(pattern)
        map1={}
        map2={}
        
        for i in range(n):
            if pattern[i] not in map1:
                map1[pattern[i]]=words[i]
            elif map1[pattern[i]]!=words[i]:
                return False
            
            if words[i] not in map2:
                map2[words[i]]=pattern[i]
            elif map2[words[i]]!=pattern[i]:
                return False
            
        return True