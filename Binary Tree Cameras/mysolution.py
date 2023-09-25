# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.cover=set([None])
        self.ans=0
    
    def dfs(self,node,parent):
        if node:
            self.dfs(node.left,node)
            self.dfs(node.right,node)
            
            if (node.left not in self.cover or node.right not in self.cover) or (not parent and node not in self.cover):
                self.cover.add(node)
                self.cover.add(node.left)
                self.cover.add(node.right)
                self.cover.add(parent)
                self.ans+=1
            
            
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        self.dfs(root,None)
        return self.ans