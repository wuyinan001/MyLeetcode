class Codec:
    def encode(self, strs: [str]) -> str:
        """Encodes a list of strings to a single string.
        """
        ans=[]
        for s in strs:
            str_len=str(len(s))
            while len(str_len)<4:
                str_len="0"+str_len
            ans.append(str_len+s)
        
        return ''.join(ans)
        

    def decode(self, s: str) -> [str]:
        """Decodes a single string to a list of strings.
        """
        ans=[]
        index=0
        n=len(s)
        
        while index<n:
            length=int(s[index:index+4])
            index+=4
            ans.append(s[index:index+length])
            index+=length
        
        return ans


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))