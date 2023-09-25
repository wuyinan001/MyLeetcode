# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans=0
    
    def dfs(self,node):
        if node==None:
            return 0
                
        left=self.dfs(node.left)
        if node.left:
            left+=1
            
        right=self.dfs(node.right)
        if node.right:
            right+=1
        
        self.ans=max(self.ans,left+right)
        
        return max(left,right)
    
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.dfs(root)
        return self.ans