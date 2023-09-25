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
    
    double ans=Double.MIN_VALUE;
    
    // update the max average in given subtree and return the sum and num of nodes in given subtree
    private int[] helper(TreeNode root)
    {
        if(root==null)
            return new int[]{0,0};
        
        int sum=root.val;
        int count=1;
        
        int[] left=helper(root.left);
        int[] right=helper(root.right);
        
        sum+=left[0];
        sum+=right[0];
        
        count+=left[1];
        count+=right[1];
        
        double avg=(double)sum/count;
        
        ans=Math.max(ans,avg);
        
        return new int[]{sum,count};
    }
    
    public double maximumAverageSubtree(TreeNode root) {
        
        helper(root);
        
        return ans;
    }
    
    
}