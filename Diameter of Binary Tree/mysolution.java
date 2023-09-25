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
            return 0;
        
        int left=dfs(node.left), right=dfs(node.right);
        
        if(node.left==null&&node.right==null)
        {
            return 0;
        }
        else if(node.left==null)
        {
            ans=Math.max(ans,right+1);
            return right+1;
        }
        else if(node.right==null)
        {
            ans=Math.max(ans,left+1);
            return left+1;
        }
        else
        {
            ans=Math.max(ans,left+right+2);
            return Math.max(left,right)+1;
        }

    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        dfs(root);
        
        return ans;
        
    }
}