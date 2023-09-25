# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.ans=0
        self.map=defaultdict(int)
        self.map[0]=1
        self.targetSum=0
    
    def dfs(self,node,prev):
        if node==None:
            return
        
        presum=node.val+prev
        
        #print("presum",presum,"node.val",node.val)
        
        self.ans+=self.map[presum-self.targetSum]
        self.map[presum]+=1

        self.dfs(node.left,presum)
        self.dfs(node.right,presum)
        
        self.map[presum]-=1
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        self.targetSum=targetSum
        self.dfs(root,0)
        
        #print(self.map)
        
        return self.ans