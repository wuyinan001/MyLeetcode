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
    
    int ans=0;
    
    private int dfs(TreeNode node)
    {
        if(node==null)
            return -1;
        
        int left=dfs(node.left), right=dfs(node.right);
        
        ans=Math.max(ans,2+left+right);
        
        return Math.max(left,right)+1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        dfs(root);
        
        return ans;
    }
}