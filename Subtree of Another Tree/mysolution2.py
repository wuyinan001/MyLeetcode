# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self,t1,t2):
        if t1==None and t2==None:
            return True
        elif t1==None or t2==None:
            return False
        else:
            return t1.val==t2.val and self.isSameTree(t1.left,t2.left) and self.isSameTree(t1.right,t2.right)
        
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root==None:
            return subRoot==None
        return self.isSameTree(root,subRoot) or self.isSubtree(root.left,subRoot) or self.isSubtree(root.right,subRoot)