/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int sum=0;
    
    private void sumToLeaf(TreeNode root)
    {
        if(root==null)
            return;
        
        if(root.left==null&&root.right==null)
            sum+=root.val;
        
        if(root.left!=null)
        {
            root.left.val=root.left.val+2*root.val;
            sumToLeaf(root.left);
        }
            
        if(root.right!=null)
        {
            root.right.val=root.right.val+2*root.val;
            sumToLeaf(root.right);
        }
        
        
    }

    public int sumRootToLeaf(TreeNode root) {
        
        sumToLeaf(root);
        
        return sum;
    }
}