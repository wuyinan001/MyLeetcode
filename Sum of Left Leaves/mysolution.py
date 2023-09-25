# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:    
    def sumOfLeftLeaves1(self,node,prt):
        if node==None:
            return 0
        
        if prt==None:
            return self.sumOfLeftLeaves1(node.left,node)+self.sumOfLeftLeaves1(node.right,node)
        
        if node.left==None and node.right==None and prt.left==node:
            return node.val
        
        return self.sumOfLeftLeaves1(node.left,node)+self.sumOfLeftLeaves1(node.right,node)
    
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        return self.sumOfLeftLeaves1(root,None)