# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self,node,key):
        if node==None:
            return None
        
        if key<node.val:
            node.left=self.dfs(node.left,key)
            return node
        elif key>node.val:
            node.right=self.dfs(node.right,key)
            return node
        else:
            if node.left==None and node.right==None:
                return None
            elif node.left==None:
                return node.right
            elif node.right==None:
                return node.left
            else:
                curr=node.right
                while curr.left:
                    curr=curr.left
                curr.left=node.left
                return node.right


    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        return self.dfs(root,key)