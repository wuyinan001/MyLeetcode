class StockSpanner:

    def __init__(self):
        self.stack=[]
        self.index=1

    def next(self, price: int) -> int:
        while self.stack and self.stack[-1][1]<=price:
            self.stack.pop()
        
        if self.stack:
            ans=self.index-self.stack[-1][0]
        else:
            ans=self.index

        self.stack.append((self.index,price))
        self.index+=1

        return ans


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)