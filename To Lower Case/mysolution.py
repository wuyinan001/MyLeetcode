class Solution:
    def toLowerCase(self, s: str) -> str:
        L=[]
        for c in s:
            if ord(c)>=ord('A') and ord(c)<=ord('Z'):
                L.append(chr(ord(c)-ord('A')+ord('a')))
            else:
                L.append(c)

        return ''.join(L)