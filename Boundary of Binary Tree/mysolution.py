# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.leftB=[]
        self.rightB=[]
        self.bottom=[]
    
    def isLeaf(self,node):
        if node==None:
            return False
        
        return node.left==None and node.right==None
    
        
    def leftBound(self,node):
        if not node or self.isLeaf(node):
            return
        
        self.leftB.append(node.val)
        
        if node.left!=None:
            self.leftBound(node.left)
        else:
            self.leftBound(node.right)
            
    def rightBound(self,node):
        if not node or self.isLeaf(node):
            return
        
        self.rightB.append(node.val)
        
        if node.right!=None:
            self.rightBound(node.right)
        else:
            self.rightBound(node.left)
            
    def bottomBound(self,node):
        if not node:
            return
        
        if self.isLeaf(node):
            self.bottom.append(node.val)
        else:
            self.bottomBound(node.left)
            self.bottomBound(node.right)
        
    def boundaryOfBinaryTree(self, root: Optional[TreeNode]) -> List[int]:
        ans=[]
        if not root:
            return ans
        
        if self.isLeaf(root):
            return [root.val]
        
        self.leftBound(root.left)
        self.rightBound(root.right)
        self.rightB.reverse()
        self.bottomBound(root)
        
        ans.append(root.val)
        ans.extend(self.leftB)
        ans.extend(self.bottom)
        ans.extend(self.rightB)
        
        return ans