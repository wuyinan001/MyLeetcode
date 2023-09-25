# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.red=None
    
    def findRed(self,node,val):
        
        if node==None:
            return
        
        if node.val==val:
            self.red=node
            return
        
        self.findRed(node.left,val)
        self.findRed(node.right,val)
    
    def count(self,node):
        if node==None:
            return 0
        return 1+self.count(node.left)+self.count(node.right)
    
    def btreeGameWinningMove(self, root: Optional[TreeNode], n: int, x: int) -> bool:
        
        self.findRed(root,x)
        
        left=self.count(self.red.left)
        right=self.count(self.red.right)
        p=n-1-left-right
        
        return left>n-left or right>n-right or p>n-p