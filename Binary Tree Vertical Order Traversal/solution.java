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
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList();
        
        if(root==null)
            return ans;
        
        Queue<Pair<TreeNode,Integer>> queue=new LinkedList();
        Map<Integer,List<Integer>> map=new HashMap();
        
        queue.add(new Pair(root,0));
        
        while(!queue.isEmpty())
        {
            Pair<TreeNode,Integer> pair=queue.remove();
            
            TreeNode node=pair.getKey();
            int col=pair.getValue();
            
            if(!map.containsKey(col))
            {
                List<Integer> list=new ArrayList();
                list.add(node.val);
                map.put(col,list);
            }
            else
                map.get(col).add(node.val);
            
            if(node.left!=null)
                queue.add(new Pair(node.left,col-1));  
            
            if(node.right!=null)
                queue.add(new Pair(node.right,col+1));     
        }
        
        List<Integer> columnList=new ArrayList(map.keySet());
        
        Collections.sort(columnList);
        
        for(Integer i:columnList)
            ans.add(map.get(i));
        
        return ans;
    }
}