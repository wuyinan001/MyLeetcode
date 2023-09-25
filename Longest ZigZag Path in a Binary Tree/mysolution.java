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
    
    private int[] dfs(TreeNode node)
    {
        if(node==null)
            return new int[]{0,0};
        
        int[] left=dfs(node.left), right=dfs(node.right);
        
        int curr_left=0, curr_right=0;
        
        if(node.left!=null)
            curr_left=1+left[1];
        
        if(node.right!=null)
            curr_right=1+right[0];
        
        ans=Math.max(ans,Math.max(curr_left,curr_right));
        
        return new int[]{curr_left,curr_right};
    }
    
    public int longestZigZag(TreeNode root) {
        
        dfs(root);
        
        return  ans;
    }
}