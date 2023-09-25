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
    
    int maxSum=Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        maxGain(root);
        
        return maxSum;
    }
    
    // Max Gain returns the max sum of path on one side branch from input node (including input node)
    private int maxGain(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int leftGain=Math.max(0,maxGain(root.left)),rightGain=Math.max(0,maxGain(root.right));
        
        // If the current node provides a larger maxSum, update maxSum
        maxSum=Math.max(root.val+leftGain+rightGain,maxSum);
        
        return root.val+Math.max(leftGain,rightGain);
    }
}