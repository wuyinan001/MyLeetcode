class Codec:
    def encode(self, strs: [str]) -> str:
        """Encodes a list of strings to a single string.
        """
        ans=""
        for str1 in strs:
            str_len=str(len(str1))
            while len(str_len)<4:
                str_len="0"+str_len
            ans=ans+str_len+str1
        
        #print(ans)
        return ans
        

    def decode(self, s: str) -> [str]:
        """Decodes a single string to a list of strings.
        """
        ans=[]
        curr=0
        
        while curr<len(s):
            length=int(s[curr:curr+4])
            curr+=4
            ans.append(s[curr:curr+length])
            curr+=length
            
        return ans


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))