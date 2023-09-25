class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        n1=len(haystack)
        n2=len(needle)
        
        if n2==0:
            return 0
        
        if n1<n2:
            return -1
        
        i=0
        j=0
        
        while i<n1:
            #print(i," i")
            #print(j," j")

            if haystack[i]==needle[j]:
                i=i+1
                j=j+1
            elif haystack[i]!=needle[j]:
                i=i+1-j
                j=0
                
            # Found the same string
            if j==n2:
                return i-j
            
        return -1