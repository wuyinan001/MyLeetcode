# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isLeaf(self,node):
        if node==None:
            return False
        
        return node.left==None and node.right==None
    
    def dfs(self,node,curr):
        if self.isLeaf(node):
            return curr*10+node.val
        
        ans=0
        if node.left!=None:
            ans+=self.dfs(node.left,curr*10+node.val)
        
        if node.right!=None:
            ans+=self.dfs(node.right,curr*10+node.val)
        
        return ans
        
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root==None:
            return 0
        
        return self.dfs(root,0)