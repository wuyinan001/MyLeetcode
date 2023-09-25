class MaxStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.maxstack=[]

    def push(self, x: int) -> None:
        max= x if not self.maxstack or self.maxstack[-1]<x else self.maxstack[-1]
        self.maxstack.append(max)
        self.stack.append(x)
        

    def pop(self) -> int:
        x=self.stack.pop()
        self.maxstack.pop()
        return x
        

    def top(self) -> int:
        return self.stack[-1]
        

    def peekMax(self) -> int:
        return self.maxstack[-1]
        

    def popMax(self) -> int:
        max=self.maxstack[-1]
        buffer=[]
        while self.stack[-1]<max:
            buffer.append(self.stack.pop())
            self.maxstack.pop()
        self.stack.pop()
        self.maxstack.pop()
        while buffer:
            self.push(buffer.pop())
            
        return max        
        
# Your MaxStack object will be instantiated and called as such:
# obj = MaxStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.peekMax()
# param_5 = obj.popMax()