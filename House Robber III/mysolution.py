# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.memoA={None:0}
        self.memoB={None:0}
    
    # max if select the node
    def maxA(self,node):
        if node in self.memoA:
            return self.memoA[node]
        
        ans=node.val+self.maxB(node.left)+self.maxB(node.right)
        self.memoA[node]=ans
        
        return ans
        
    # max if not select the node
    def maxB(self,node):
        if node in self.memoB:
            return self.memoB[node]
        
        ans=max(self.maxA(node.left),self.maxB(node.left))+\
        max(self.maxA(node.right),self.maxB(node.right))
        self.memoB[node]=ans 
            
        return ans
    
    def rob(self, root: Optional[TreeNode]) -> int:
        return max(self.maxA(root),self.maxB(root))