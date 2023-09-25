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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        
        
        if(root==null)
            return false;
        
        //System.out.println(root.val);
        //System.out.println(root.left);
        //System.out.println(root.right);
        
        // if a node.left==null and node.right==null, that node is a leaf
        if(root.val==sum&&root.left==null&&root.right==null)
            return true;
        
        
        return (hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val));
    }
}