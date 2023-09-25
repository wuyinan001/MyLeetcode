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
class BSTIterator {
    
    private Queue<Integer> queue;
    
    public BSTIterator(TreeNode root) {
        
        queue=new LinkedList<>();
        addQueue(root);
    }
    
    private void addQueue(TreeNode root)
    {
        if(root==null)
            return;
        
        addQueue(root.left);
        queue.add(root.val);
        addQueue(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        
        return queue.remove();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */