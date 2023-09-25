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
        
        coins=self.dfs(node.left)+self.dfs(node.right)+node.val-1
        self.ans+=abs(coins)
        return coins
    
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.dfs(root)
        return self.ans