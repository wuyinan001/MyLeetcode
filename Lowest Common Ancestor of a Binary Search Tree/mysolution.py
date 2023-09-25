# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root==p:
            return p
        if root==q:
            return q
        
        if (p.val<root.val and q.val>root.val) or (p.val>root.val and q.val<root.val):
            return root
        
        if p.val<root.val and q.val<root.val:
            return self.lowestCommonAncestor(root.left,p,q)
        
        return self.lowestCommonAncestor(root.right,p,q)