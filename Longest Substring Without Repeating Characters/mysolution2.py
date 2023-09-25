class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        set1=set([])
        start=0
        end=0
        length=0
        
        while end<len(s):
            #print(set1)
            if s[end] in set1:
                if length<end-start:
                    length=end-start
                while s[end] in set1:
                    set1.remove(s[start])
                    start+=1
            
            set1.add(s[end])
            end+=1
        
        if len(set1)==end-start and length<end-start:
            length=end-start
        
        return length