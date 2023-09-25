# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.first=None
        self.prev=None
        
    def dfs(self,node):
        if node!=None:
            if self.first==None:
                self.first=node
                
            if self.prev!=None:
                self.prev.right=node
            
            self.prev=node
            
            left=node.left
            node.left=None
            right=node.right
            node.right=None
            
            self.dfs(left)
            self.dfs(right)

        
        
        
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.dfs(root)
        root=self.first