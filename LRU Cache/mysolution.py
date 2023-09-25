class LRUCache:

    class Node:
        def __init__(self,key,val):
            self.key=key
            self.val=val
            self.next=None
            self.prev=None
    
    def __init__(self, capacity: int):
        self.head=self.Node(-1,-1)
        self.tail=self.Node(-2,-2)
        self.dict={}
        self.cap=capacity
        self.head.next=self.tail
        self.tail.prev=self.head
        
    def insert(self,node):
        node.prev=self.tail.prev
        node.next=self.tail
        node.prev.next=node
        self.tail.prev=node
        
    def delete(self,node):
        node.prev.next=node.next
        node.next.prev=node.prev

    def get(self, key: int) -> int:
        if key in self.dict:
            node=self.dict[key]
            self.delete(node)
            self.insert(node)
            return node.val 
        else:
            return -1
        

    def put(self, key: int, value: int) -> None:
        if key in self.dict:
            node=self.dict[key]
            node.val=value
            self.delete(node)
            self.insert(node)
        else:
            if len(self.dict)==self.cap:
                del self.dict[self.head.next.key]
                self.delete(self.head.next)
 
            node=self.Node(key,value)
            self.insert(node)
            self.dict[key]=node
                
                

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)