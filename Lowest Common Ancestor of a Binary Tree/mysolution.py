# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def __init__(self):
        self.lca=None
    
    def dfs(self,node,p,q):
        if node==None:
            return 0
        
        left=self.dfs(node.left,p,q)
        right=self.dfs(node.right,p,q)
        mid=0
        
        if node==p or node==q:
            mid=1
        
        if (left==1 and mid==1) or (mid==1 and right==1) or (left==1 and right==1):
            self.lca=node
        
        return left+mid+right
        
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        self.dfs(root,p,q)
        return self.lca