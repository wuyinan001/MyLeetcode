class MyObjs:
    def __init__(self,x,y):
        self.x=x
        self.y=y
        
    def __lt__(self,other):
        if self.x==other.x:
            return self.y<other.y
        return self.x>other.x

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        queue=[]
        for p in people:
            queue.append(MyObjs(p[0],p[1]))
        
        queue.sort()
        ans=[]
        
        for p in queue:
            ans.insert(p.y,[p.x,p.y])
        
        return ans