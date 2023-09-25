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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        
        TreeNode current=root;
        
        while(current!=null||!stack.isEmpty())
        {
            while(current!=null)
            {
                stack.push(current);
                current=current.left;
            }
            
            current=stack.pop();
            ans.add(current.val);
            
            current=current.right;
        }
        
        return ans;
    }
}