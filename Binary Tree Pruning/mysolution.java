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
    
    // Retur true if the subtree of root doesn't contains; false if the subtree of root contains 1
    
    private boolean dfs(TreeNode root)
    {
        if(root==null)
            return true;
        
        boolean left=dfs(root.left), right=dfs(root.right);
        
        return left&&right&&root.val!=1;
            
    }
    
    public TreeNode pruneTree(TreeNode root) {
        
        if(dfs(root))
            return null;
        
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        
        return root;
    }
}