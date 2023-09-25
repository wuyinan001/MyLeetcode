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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        
        if(isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(depth(root.left)-depth(root.right))<=1)
            return true;
        else
            return false;
    }
    
    private int depth(TreeNode root)
    {
        if(root==null)
            return 0;
        
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}