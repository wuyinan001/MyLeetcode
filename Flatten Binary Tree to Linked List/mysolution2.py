# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev=None
    
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root!=None:
            t1=root.left
            t2=root.right
            root.left=None
            root.right=None
            
            if self.prev!=None:
                self.prev.right=root
            self.prev=root
                
            self.flatten(t1)
            self.flatten(t2)