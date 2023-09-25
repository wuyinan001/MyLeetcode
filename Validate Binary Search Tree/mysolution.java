/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root==null)
            return true;
        
        if(root.left==null&&root.right==null)
            return true;
        
        if(root.left==null&&root.right!=null)
        {
            if(isValidBST(root.right)&&root.val<leftMost(root.right))
                return true;
            else
                return false;
        }
        
        if(root.left!=null&&root.right==null)
        {
            if(isValidBST(root.left)&&root.val>rightMost(root.left))
                return true;
            else
                return false;
        }
        
        
        if(isValidBST(root.right)&&root.val<leftMost(root.right)&&isValidBST(root.left)&&root.val>rightMost(root.left))
            return true;
        
        return false;
    }
    
    private int leftMost(TreeNode root)
    {
        if(root.left==null)
            return root.val;
        
        return leftMost(root.left);
    }
    
    private int rightMost(TreeNode root)
    {
        if(root.right==null)
            return root.val;
        
        return rightMost(root.right);
    }
}