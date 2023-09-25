class Vector2D:
    def __init__(self, vec: List[List[int]]):
        self.stack=vec[::-1]

    def next(self) -> int:
        while self.stack and len(self.stack[-1])==0:
            self.stack.pop()
        return self.stack[-1].pop(0)

    def hasNext(self) -> bool:
        while self.stack and len(self.stack[-1])==0:
            self.stack.pop()
        return self.stack


# Your Vector2D object will be instantiated and called as such:
# obj = Vector2D(vec)
# param_1 = obj.next()
# param_2 = obj.hasNext()