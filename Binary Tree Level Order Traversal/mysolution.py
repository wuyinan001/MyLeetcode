# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        ans=[]
        
        if root==None:
            return ans
        
        queue=[]
        queue.append(root)
        
        while queue:
            size=len(queue)
            list1=[]
            
            for i in range(size):
                node=queue.pop(0)
                list1.append(node.val)
                if node.left!=None:
                    queue.append(node.left)
                if node.right!=None:
                    queue.append(node.right)
            
            ans.append(list1)
        
        return ans