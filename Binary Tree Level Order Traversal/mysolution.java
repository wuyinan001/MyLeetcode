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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
            return result;
        
        queue1.add(root);
        
        while(!queue1.isEmpty())
        {
            List<Integer> layer=new ArrayList<>();
            
            while(!queue1.isEmpty())
            {
                TreeNode t=queue1.remove();
                layer.add(t.val);
                queue2.add(t);
            }
            
            result.add(layer);
            
            while(!queue2.isEmpty())
            {
                TreeNode t=queue2.remove();
                if(t.left!=null)
                    queue1.add(t.left);
                if(t.right!=null)
                    queue1.add(t.right);
            }
                
        }
        
        return result;
    }
}