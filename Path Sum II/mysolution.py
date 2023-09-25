# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        
        if root==None:
            return None
        
        if root.left==None and root.right==None and root.val==sum:
            return [[sum]]
        
        if root.left==None and root.right==None and root.val!=sum:
            return None
        
        ans=[]
        
        
        ans_left=self.pathSum(root.left,sum-root.val)
        ans_right=self.pathSum(root.right,sum-root.val)
        
        #print("root.val",root.val)
        #print("ans_left",ans_left)
        #print("ans_right",ans_right)
        
        if ans_left!=None:
            for x in ans_left:
                x.insert(0,root.val)
                ans.append(x)
                
        if ans_right!=None:
            for x in ans_right:
                x.insert(0,root.val)
                ans.append(x)
        
        return ans