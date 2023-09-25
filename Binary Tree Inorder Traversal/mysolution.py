# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack=[]
        ans=[]

        node=root
        while node:
            stack.append(node)
            node=node.left
        
        while stack:
            node=stack[-1]
            ans.append(node.val)
            if node.right:
                node=node.right
                while node:
                    stack.append(node)
                    node=node.left
            else:
                node=stack.pop()
                while stack and stack[-1].right==node:
                    node=stack.pop()
        
        return ans