class Solution:
    def smallestSubsequence(self, s: str) -> str:
        stack=[]
        set1=set([])
        map1={}
        n=len(s)
        
        for i in range(n):
            map1[s[i]]=i
        
        for i in range(n):
            if s[i] not in set1:
                while stack and ord(stack[-1])>ord(s[i]) and map1[stack[-1]]>i:
                    set1.remove(stack.pop())
                    
                stack.append(s[i])
                set1.add(s[i])
        
        return ''.join(stack)