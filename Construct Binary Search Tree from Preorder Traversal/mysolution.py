# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        if len(preorder)==0:
            return None
        
        ans=TreeNode(preorder[0])
        index=1
        n=len(preorder)
        
        leftList=[]
        rightList=[]
        
        while index<n:
            if preorder[index]>ans.val:
                break
            leftList.append(preorder[index])
            index+=1
        
        while index<n:
            rightList.append(preorder[index])
            index+=1
        
        ans.left=self.bstFromPreorder(leftList)
        ans.right=self.bstFromPreorder(rightList)
        
        return ans