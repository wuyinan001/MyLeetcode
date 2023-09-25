import heapq

class MyObjs:
    def __init__(self,letter,freq,pos):
        self.letter=letter
        self.freq=freq
        self.pos=pos
    
    def __lt__(self,other):
        return self.freq>other.freq
    
    def __repr__(self):
        return "{},{},{}".format(chr(self.letter+ord('a')),self.freq,self.pos)

class Solution:
    def rearrangeString(self, s: str, k: int) -> str:
        pq=[]
        heapq.heapify(pq)
        
        freq=[0 for i in range(26)]
        
        for i in s:
            freq[ord(i)-ord('a')]+=1
        
        for i in range(26):
            if freq[i]!=0:
                heapq.heappush(pq,MyObjs(i,freq[i],0))
        
        ans=[]
        queue=[]
        
        for i in range(len(s)):
            while queue and queue[0].pos<=i:
                heapq.heappush(pq,queue.pop(0))
            
            if not pq:
                return ""
            
            obj:MyObjs=heapq.heappop(pq)
            ans.append(chr(obj.letter+ord('a')))
            obj.freq-=1
            #print(ans)
            
            if obj.freq>0:
                queue.append(MyObjs(obj.letter,obj.freq,i+k))
            
        return ''.join(ans)