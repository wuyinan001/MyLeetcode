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
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root==null)
            return 0;
        
        Integer width=1;
        
        Queue<Pair<TreeNode,Integer>> queue=new LinkedList();
        
        queue.add(new Pair(root,0));
        
        while(!queue.isEmpty())
        {
            int n=queue.size();
            int min=queue.peek().getValue(), max=0;
            
            
            for(int i=0;i<n;i++)
            {
                Pair<TreeNode,Integer> pair=queue.remove();
                int index=pair.getValue();
                TreeNode node=pair.getKey();
                
                if(i==n-1)
                    max=index;
                
                if(node.left!=null)
                    queue.add(new Pair(node.left,2*index));
                
                if(node.right!=null)
                    queue.add(new Pair(node.right,2*index+1));
                
            }
            
            //System.out.println("min "+min+" max "+max);
            width=Math.max(width,max-min+1);
            //System.out.println("width "+width);
        }
        
        return width;
    }
}