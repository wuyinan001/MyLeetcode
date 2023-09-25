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
    
    Set<TreeNode> covered;
    int ans=0;
    
    public int minCameraCover(TreeNode root) {
            
        covered=new HashSet();
        covered.add(null);
        
        dfs(root,null);
        
        return ans;
    }
    
    private void dfs(TreeNode root, TreeNode par)
    {
        if(root!=null)
        {
            dfs(root.left,root);
            dfs(root.right,root);
            
            if(!covered.contains(root.left)||!covered.contains(root.right)||(par==null&&!covered.contains(root)))
            {
                ans++;
                covered.add(root);
                covered.add(par);
                covered.add(root.left);
                covered.add(root.right);
            }
        }
    }
}