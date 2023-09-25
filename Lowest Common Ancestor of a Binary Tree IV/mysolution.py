# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans=None
    
    def dfs(self,node,nodes):
        if node==None:
            return 0
        
        mid=0
        
        if node in nodes:
            mid=1
            
        left=self.dfs(node.left,nodes)
        right=self.dfs(node.right,nodes)
        
        if not (left==len(nodes) or right==len(nodes)) and (left+right+mid==len(nodes)):
            self.ans=node
        
        return left+right+mid
    
    def lowestCommonAncestor(self, root: 'TreeNode', nodes: 'List[TreeNode]') -> 'TreeNode':
        self.dfs(root,nodes)
        
        return self.ans