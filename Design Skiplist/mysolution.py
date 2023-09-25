import random

class Node:
    def __init__(self,val=-1):
        self.val=val
        self.next=None
        self.down=None
    
class Skiplist:

    def __init__(self):
        self.head=Node()

    def search(self, target: int) -> bool:
        curr=self.head
        
        while curr!=None:
            while curr.next!=None and target>curr.next.val:
                curr=curr.next
            if curr.next!=None and target==curr.next.val:
                return True
            curr=curr.down
        
        return False
        

    def add(self, num: int) -> None:
        stack=[]
        insert=True
        down=None
        
        curr=self.head
        
        while curr!=None:
            while curr.next!=None and num>curr.next.val:
                curr=curr.next
            stack.append(curr)
            curr=curr.down
        
        while stack and insert:
            node=Node(num)
            prenode=stack.pop()
            node.next=prenode.next
            prenode.next=node
            node.down=down
            down=node
            insert=random.uniform(0,1)>0.5
        
        while insert:
            node=Node(num)
            prenode=Node(-1)
            node.next=prenode.next
            prenode.next=node
            node.down=down
            down=node
            prenode.down=self.head
            self.head=prenode
            insert=random.uniform(0,1)>0.5
        
    def erase(self, num: int) -> bool:
        curr=self.head
        delete=False
        
        while curr!=None:
            while curr.next!=None and num>curr.next.val:
                curr=curr.next
            if curr.next!=None and num==curr.next.val:
                curr.next=curr.next.next
                delete=True
            curr=curr.down
        
        return delete


# Your Skiplist object will be instantiated and called as such:
# obj = Skiplist()
# param_1 = obj.search(target)
# obj.add(num)
# param_3 = obj.erase(num)