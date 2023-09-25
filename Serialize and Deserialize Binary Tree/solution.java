/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private StringBuilder serialize(TreeNode root,StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("null,");
            return sb;
        }
            
        sb.append(root.val+",");
        sb=serialize(root.left,sb);
        sb=serialize(root.right,sb);
        
        return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb=new StringBuilder();
        
        sb=serialize(root,sb);
        
        
        //System.out.println(sb.toString());
        
        return sb.toString();
        
    }
    
    private TreeNode deserialize(List<String> list)
    {
        if(list.get(0).equals("null"))
        {
            list.remove(0);
            return null;
        }
            
        
        TreeNode root=new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left=deserialize(list);
        root.right=deserialize(list);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] strs=data.split(",");
        List<String> list=new ArrayList<>(Arrays.asList(strs));
        
        
        return deserialize(list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));