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
    public int maxPathSum(TreeNode root) {
        
        if(root==null)
            return 0;
        
        if(root.left==null&&root.right==null)
            return root.val;
        
        //System.out.println("Max Gain: "+maxGain(root.right));
        
        if(root.left==null)
            return Math.max(maxPathSum(root.right),Math.max(root.val+maxGain(root.right),Math.max(root.val,maxGain(root.right))));
        
        if(root.right==null)
            return Math.max(maxPathSum(root.left),Math.max(root.val+maxGain(root.left),Math.max(root.val,maxGain(root.left))));
        
        
        int cand1=maxPathSum(root.left), cand2=maxPathSum(root.right);
        
        int cand3=root.val;
        
        int leftGain=maxGain(root.left),rightGain=maxGain(root.right);
        
        if(leftGain>0)
            cand3+=leftGain;
        
        if(rightGain>0)
            cand3+=rightGain;
        
        return Math.max(cand1,Math.max(cand2,cand3));
    }
    
    // Max Gain returns the max sum of path on one side branch from input node (including input node)
    private int maxGain(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int leftGain=maxGain(root.left),rightGain=maxGain(root.right);
        
        return root.val+Math.max(0,Math.max(leftGain,rightGain));
    }
}