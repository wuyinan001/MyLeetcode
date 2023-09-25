class Solution:
    def __init__(self):
        self.dict={}

        for i in range(26):
            r=int(i/5)
            c=i%5
            self.dict[chr(i+ord('a'))]=(r,c)

    def getPath(self,s,t):
        ans=""
        dr=self.dict[t][0]-self.dict[s][0]
        dc=self.dict[t][1]-self.dict[s][1]

        if s=='z':
            for _ in range(abs(dr)):
                ans+='U'
            for _ in range(abs(dc)):
                ans+='R'
        else:
            if dc>=0:
                for _ in range(abs(dc)):
                    ans+='R'
            else:
                for _ in range(abs(dc)):
                    ans+='L'

            if dr>=0:
                for _ in range(abs(dr)):
                    ans+='D'
            else:
                for _ in range(abs(dr)):
                    ans+='U'

        ans+='!'
        return ans

    def alphabetBoardPath(self, target: str) -> str:
        target='a'+target
        n=len(target)
        ans=""
        for i in range(n-1):
            ans=ans+self.getPath(target[i],target[i+1])
        return ans