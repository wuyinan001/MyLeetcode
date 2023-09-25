# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans=-inf
    
    def dfs(self,node):
        if node==None:
            return 0
        
        left=max(0,self.dfs(node.left))
        right=max(0,self.dfs(node.right))
        
        self.ans=max(self.ans,node.val+left+right)
        
        return max(left,right)+node.val
        
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.dfs(root)
        return self.ans