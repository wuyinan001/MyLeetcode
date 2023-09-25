/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n=inorder.length;
        TreeNode ans=null;
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        
        for(int i=n-1;i>=0;i--)
        {
            ans=addToTree(ans,postorder[i],map);
        }
        
        return ans;
    }
    
    private TreeNode addToTree(TreeNode tree, int value, Map<Integer,Integer> map)
    {
        if(tree==null)
            tree=new TreeNode(value);
        else if(map.get(value)<map.get(tree.val))
            tree.left=addToTree(tree.left,value,map);
        else
            tree.right=addToTree(tree.right,value,map);
        
        return tree;
    }
}