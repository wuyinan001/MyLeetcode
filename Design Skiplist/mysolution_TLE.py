import random

class Node:
    def __init__(self,val=0):
        self.val=val
        self.next=None
        self.down=None

class Skiplist:

    def __init__(self):
        self.head=Node(-1)

    def search(self, target: int) -> bool:
        curr=self.head
        
        while curr!=None:
            while curr.next!=None and curr.next.val<target:
                curr=curr.next
            if curr.next!=None and curr.next.val==target:
                return True
            else:
                curr=curr.down
        
        return False

    def add(self, num: int) -> None:
        stack=[]
        # temp: temporary down pointer
        temp=None
        coin=True
        
        curr=self.head
        
        while curr!=None:
            while curr.next!=None and curr.next.val<num:
                curr=curr.next
            stack.append(curr)
            curr=curr.down
        
        while coin and stack:
            node=stack.pop()
            new_node=Node(num)
            new_node.next=node.next
            node.next=new_node
            new_node.down=temp
            temp=new_node
            if random.random()<0.5:
                coin=False

    def erase(self, num: int) -> bool:
        curr=self.head
        ans=False
        while curr!=None:
            while curr.next!=None and curr.next.val<num:
                curr=curr.next
            if curr.next!=None and curr.next.val==num:
                ans=True
                curr.next=curr.next.next
            
            curr=curr.down
        
        return ans


# Your Skiplist object will be instantiated and called as such:
# obj = Skiplist()
# param_1 = obj.search(target)
# obj.add(num)
# param_3 = obj.erase(num)