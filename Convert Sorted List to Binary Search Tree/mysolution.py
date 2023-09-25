"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def __init__(self):
        self.first=None
        self.prev=None
    
    def dfs(self,node):
        if node!=None:
            self.dfs(node.left)
            if self.first==None:
                self.first=node
            
            if self.prev!=None:
                self.prev.right=node
                node.left=self.prev
            
            self.prev=node
            self.dfs(node.right)
    
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root==None:
            return None
        
        self.dfs(root)
        self.first.left=self.prev
        self.prev.right=self.first
        
        return self.first