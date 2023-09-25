# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        
        root=TreeNode(preorder[0])
        
        index=inorder.index(preorder[0])
        n=len(preorder)
        
        left_preorder=preorder[1:index+1]
        left_inorder=inorder[0:index]
        right_preorder=preorder[index+1:n]
        right_inorder=inorder[index+1:n]

        root.left=self.buildTree(left_preorder,left_inorder)
        root.right=self.buildTree(right_preorder,right_inorder)
        
        return root