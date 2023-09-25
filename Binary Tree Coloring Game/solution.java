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
    
    
    private TreeNode getRed(TreeNode root, int x)
    {
        if(root==null)
            return null;
        
        if(root.val==x)
            return root;
        
        TreeNode left=getRed(root.left,x);
        
        if(left!=null)
            return left;
        
        return getRed(root.right,x);
    }
    
    private int numOfNodes(TreeNode root)
    {
        if(root==null)
            return 0;
        
        return 1+numOfNodes(root.left)+numOfNodes(root.right);
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        TreeNode red=getRed(root,x);
        
        int l=numOfNodes(red.left), r=numOfNodes(red.right);
        
        int p=n-1-l-r;
        
        if(l>n-l||p>n-p||r>n-r)
            return true;
        
        return false;
    }
}