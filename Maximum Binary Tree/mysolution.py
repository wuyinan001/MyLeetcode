# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        if len(nums)==0:
            return None
        
        index=0
        for i in range(1,len(nums)):
            if nums[i]>nums[index]:
                index=i
        
        ans=TreeNode(nums[index])
        
        ans.left=self.constructMaximumBinaryTree(nums[:index])
        ans.right=self.constructMaximumBinaryTree(nums[index+1:])
        
        return ans