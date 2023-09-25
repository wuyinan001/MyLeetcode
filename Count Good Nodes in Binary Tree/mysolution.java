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
    
    public int goodNodes(TreeNode root) {
        
        // This map contains the max value from the root node to the key node
        Map<TreeNode, Integer> map=new HashMap();
        Queue<TreeNode> queue=new LinkedList();
        
        queue.add(root);
        map.put(root,root.val);
        
        int ans=0;
        
        while(!queue.isEmpty())
        {
            TreeNode temp=queue.remove();
            
            if(temp.val==map.get(temp))
                ans++;
            
            if(temp.left!=null)
            {
                queue.add(temp.left);
                map.put(temp.left,Math.max(map.get(temp),temp.left.val));
            }
            
            if(temp.right!=null)
            {
                queue.add(temp.right);
                map.put(temp.right,Math.max(map.get(temp),temp.right.val));
            }
        }
        
        return ans;
    }
}