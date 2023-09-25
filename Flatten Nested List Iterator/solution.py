# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def isInteger(self) -> bool:
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        """
#
#    def getInteger(self) -> int:
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        """
#
#    def getList(self) -> [NestedInteger]:
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        """

class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.stack=nestedList[::-1]
        #print(self.stack)

    def next(self) -> int:
        self.makeStackTopInteger()
        return self.stack.pop().getInteger()
            
         
    def hasNext(self) -> bool:
        self.makeStackTopInteger()
        return len(self.stack)>0
    
    def makeStackTopInteger(self):
        while self.stack and not self.stack[-1].isInteger():
            self.stack.extend(self.stack.pop().getList()[::-1])
         

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())