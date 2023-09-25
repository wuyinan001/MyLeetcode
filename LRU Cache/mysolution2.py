class Node:
    def __init__(self,key=-1,val=-1,next=None,prev=None):
        self.key=key
        self.val=val
        self.next=next
        self.prev=prev

class LRUCache:

    def __init__(self, capacity: int):
        self.head=Node()
        self.tail=Node()
        self.head.next=self.tail
        self.tail.prev=self.head
        self.dict={}
        self.capacity=capacity
        
    def add(self,node):
        node.prev=self.tail.prev
        node.next=self.tail
        node.prev.next=node
        self.tail.prev=node
    
    def remove(self,node):
        node.prev.next=node.next
        node.next.prev=node.prev
        node.next=None
        node.prev=None

    def get(self, key: int) -> int:
        if key not in self.dict:
            #print("GET:",end=" ")
            #self.printList()
            return -1
        else:
            node=self.dict[key]
            self.remove(node)
            self.add(node)
            #print("GET:",end=" ")
            #self.printList()
            return node.val
        

    def put(self, key: int, value: int) -> None:
        if key in self.dict:
            node=self.dict[key]
            node.val=value
            self.remove(node)
            self.add(node)
        else:
            node=Node(key,value,None,None)
            self.add(node)
            self.dict[key]=node
            if len(self.dict)>self.capacity:
                node_remove=self.head.next
                self.remove(node_remove)
                del self.dict[node_remove.key]
        
        #print("PUT:",end=" ")
        #self.printList()
    
    def printList(self):
        node=self.head
        while node:
            print(node.val,end=" ")
            node=node.next
        print()

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)