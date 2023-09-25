# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # max if select the node
    def maxA(self,node):
        if node==None:
            return 0
        
        return node.val+self.maxB(node.left)+self.maxB(node.right)
        
    # max if not select the node
    def maxB(self,node):
        if node==None:
            return 0
        
        return max(self.maxA(node.left),self.maxB(node.left))+max(self.maxA(node.right),self.maxB(node.right))
    
    def rob(self, root: Optional[TreeNode]) -> int:
        return max(self.maxA(root),self.maxB(root))