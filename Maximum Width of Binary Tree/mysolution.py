# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if root==None:
            return 0
        
        queue=[]
        queue.append((root,0))
        ans=1
        
        while queue:
            size=len(queue)
            start=-1
            end=-1
            for i in range(size):
                curr=queue.pop(0)
                if i==0:
                    start=curr[1]
                
                if i==size-1:
                    end=curr[1]
                
                if curr[0].left:
                    queue.append((curr[0].left,2*curr[1]))
                
                if curr[0].right:
                    queue.append((curr[0].right,2*curr[1]+1))
            
            ans=max(ans,end-start+1)
        
        return ans