class MaxStack:

    def __init__(self):
        self.stack1=[]
        self.stack2=[]

    def push(self, x: int) -> None:
        self.stack1.append(x)
        
        if not self.stack2:
            self.stack2.append(x)
        else:
            top=self.stack2[-1]
            self.stack2.append(max(top,x))

    def pop(self) -> int:
        ans=self.stack1.pop()
        self.stack2.pop()
        return ans

    def top(self) -> int:
        return self.stack1[-1]

    def peekMax(self) -> int:
        return self.stack2[-1]

    def popMax(self) -> int:
        buf=[]
        max1=self.stack2[-1]
        
        while self.stack1 and max1!=self.stack1[-1]:
            buf.append(self.pop())
        
        self.pop()
        
        while buf:
            self.push(buf.pop())
        
        return max1


# Your MaxStack object will be instantiated and called as such:
# obj = MaxStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.peekMax()
# param_5 = obj.popMax()