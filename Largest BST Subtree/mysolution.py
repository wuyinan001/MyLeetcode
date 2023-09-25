# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.max=0

    # dfs return: (is this BST, min value under this node, max value under this node, num of nodes)
    def dfs(self,node):
        if node==None:
            return (True,float('inf'),-float('inf'),0)

        leftBST,leftMin,leftMax,leftNum=self.dfs(node.left)
        rightBST,rightMin,rightMax,rightNum=self.dfs(node.right)

        BST=False
        min_val=min(node.val,leftMin,rightMin)
        max_val=max(node.val,leftMax,rightMax)
        num=1+leftNum+rightNum

        if leftBST and rightBST and node.val>leftMax and node.val<rightMin:
            BST=True
            if self.max<num:
                self.max=num

        return (BST,min_val,max_val,num)

    def largestBSTSubtree(self, root: Optional[TreeNode]) -> int:
        self.dfs(root)
        return self.max