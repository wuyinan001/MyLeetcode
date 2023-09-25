# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def toList(self,root):
        ans=[]
        if root==None:
            return ans
        
        ans.extend(self.toList(root.left))
        ans.append(root.val)
        ans.extend(self.toList(root.right))
        
        return ans
    
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        return self.toList(root)[k-1]