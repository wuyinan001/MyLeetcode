# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sameTree(self,tree1,tree2):
        if tree1==None and tree2==None:
            return True
        elif tree1==None or tree2==None:
            return False
        else:
            return tree1.val==tree2.val and self.sameTree(tree1.left,tree2.left) and self.sameTree(tree1.right,tree2.right)
    
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root==None:
            return False
        return self.sameTree(root,subRoot) or self.isSubtree(root.left,subRoot) or self.isSubtree(root.right,subRoot)