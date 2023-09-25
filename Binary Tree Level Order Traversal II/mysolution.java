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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null)
            return result;
        
        Stack<List<Integer>> stack=new Stack<>();
        
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            List<Integer> layer=new ArrayList<>();
            
            for(int i=0;i<n;i++)
            {
                TreeNode t=queue.remove();
                
                layer.add(t.val);
                
                if(t.left!=null)
                    queue.add(t.left);
                
                if(t.right!=null)
                    queue.add(t.right);
            }
            
            stack.push(layer);
        }
        
        while(!stack.isEmpty())
            result.add(stack.pop());
        
        return result;
    }
}