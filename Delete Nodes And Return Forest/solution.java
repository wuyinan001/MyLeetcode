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
    
    List<TreeNode> ans=new ArrayList();
    Set<Integer> set=new HashSet();
    
    private TreeNode dfs(TreeNode root)
    {
        if(root==null)
            return null;
        
        root.left=dfs(root.left);
        root.right=dfs(root.right);
        
        if(set.contains(root.val))
        {
            if(root.left!=null)
                ans.add(root.left);
            
            if(root.right!=null)
                ans.add(root.right);
            
            return null;
        }
        
        return root;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        for(int i:to_delete)
            set.add(i);
        
        TreeNode newRoot=dfs(root);
        
        if(newRoot!=null)
            ans.add(newRoot);
        
        return ans;
    }
}