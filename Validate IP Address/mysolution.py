class Solution:
    def digitOnly(self,list1):
        for s in list1:
            for c in s:
                if not (ord(c)>=ord('0') and ord(c)<=ord('9')):
                    return False
        return True
        
    def validIPAddress(self, queryIP: str) -> str:
        list1=queryIP.split('.')
        
        if len(list1)==4:
            for s in list1:
                for c in s:
                    if not (ord(c)>=ord('0') and ord(c)<=ord('9')):
                        return 'Neither'
                if s=="" or int(s)>255 or (s[0]=='0' and len(s)>1):
                    return 'Neither'
            return 'IPv4'
        
        list2=queryIP.split(':')
        
        if len(list2)==8:
            for s in list2:
                if len(s)>4 or s=="":
                    return 'Neither'
                for c in s:
                    if not((ord(c)>=ord('0') and ord(c)<=ord('9')) or (ord(c)>=ord('a') and ord(c)<=ord('f'))\
                    or (ord(c)>=ord('A') and ord(c)<=ord('F'))):
                        return 'Neither'
            return 'IPv6'
        
        return 'Neither'