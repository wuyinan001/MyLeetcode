"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""

class Solution:
    def __init__(self):
        self.ans=None
    
    def dfs(self,node,p,q):
        if node==None:
            return 0
        
        mid=0
        if node==p or node==q:
            mid+=1
        
        left=self.dfs(node.left,p,q)
        right=self.dfs(node.right,p,q)
        
        if (left==1 and right==1) or (left==1 and mid==1) or (mid==1 and right==1):
            self.ans=node
        
        return left+right+mid
    
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        root=p
        while root.parent!=None:
            root=root.parent
        
        self.dfs(root,p,q)
        return self.ans