from functools import cmp_to_key
import heapq

class Solution:
    
    class Position:
        def __init__(self,x,y,label):
            self.x=x
            self.y=y
            self.label=label
        
        def __repr__(self):
            return "[{},{},{}]".format(self.x,self.y,self.label)
    
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        list1=[]
        ans=[]
        
        for building in buildings:
            list1.append(self.Position(building[0],building[2],0))
            list1.append(self.Position(building[1],building[2],1))
        
        def compare(p1,p2):
            if p1.x==p2.x:
                if p1.label==p2.label:
                    if p1.label==0:
                        return p2.y-p1.y
                    else:
                        return p1.y-p2.y
                else:
                    return p1.label-p2.label
            else:
                return p1.x-p2.x
        
        cmp_key=cmp_to_key(compare)
        list1.sort(key=cmp_key)
        
        #print(list1)
        
        pq=[]
        heapq.heapify(pq)

        heapq.heappush(pq,0)
        
        for pos in list1:
            prev=-pq[0]
            
            if pos.label==0:
                heapq.heappush(pq,-pos.y)
                '''
                print("Add",-pos.y)
                print("pq",pq)
                print("peek",-pq[0])
                '''
                if -pq[0]>prev:
                    ans.append([pos.x,-pq[0]])
            else:
                pq.remove(-pos.y)
                heapq.heapify(pq)
                '''
                print("Remove",-pos.y)
                print("pq",pq)
                print("peek",-pq[0])
                '''
                if -pq[0]<prev:
                    ans.append([pos.x,-pq[0]])      
        
        return ans