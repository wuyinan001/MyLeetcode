import abc 
from abc import ABC, abstractmethod 
"""
This is the interface for the expression tree Node.
You should not remove it, and you can define some classes to implement it.
"""

class Node(ABC):
    @abstractmethod
    # define your fields here
    def evaluate(self) -> int:
        pass


class Operator(Node):
    def __init__(self,val=None):
        self.val=val
        self.left=None
        self.right=None
    
    def evaluate(self):
        if self.val=="+":
            return int(self.left.evaluate()+self.right.evaluate())
        elif self.val=="-":
            return int(self.left.evaluate()-self.right.evaluate())
        elif self.val=="*":
            return int(self.left.evaluate()*self.right.evaluate())
        elif self.val=="/":
            return int(self.left.evaluate()/self.right.evaluate())
        else:
            return int(self.val)
"""    
This is the TreeBuilder class.
You can treat it as the driver code that takes the postinfix input
and returns the expression tree represnting it as a Node.
"""

class TreeBuilder(object):
    def __init__(self):
        self.stack=[]
    
    def buildTree(self, postfix: List[str]) -> 'Node':
        for str1 in postfix:
            if str1=="+" or str1=="-" or str1=="*" or str1=="/":
                node=Operator(str1)
                node.right=self.stack.pop()
                node.left=self.stack.pop()
                self.stack.append(node)
            else:
                self.stack.append(Operator(str1))
        
        return self.stack.pop()
                
		
"""
Your TreeBuilder object will be instantiated and called as such:
obj = TreeBuilder();
expTree = obj.buildTree(postfix);
ans = expTree.evaluate();
"""