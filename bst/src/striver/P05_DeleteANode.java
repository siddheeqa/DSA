package striver;

public class P05_DeleteANode {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { data = val;
            left = null;
            right = null;
        }
    }
    public static TreeNode connector(TreeNode root)
    {
        //Case 1: If the node has no left child, return the right subtree to bypass the node.
        if(root.left==null) return root.right;
        //Case 2: If the node has no right child, return the left subtree to bypass the node.
        if(root.right==null) return root.left;
        /*
        Case 3: If the node has both left and right children:
        1. Save the left subtree in a temporary variable.
        2. Find the leftmost node in the right subtree.
        3. Attach the left subtree to the leftmost node in the right subtree. */
        TreeNode leftChild=root.left;
        TreeNode leftmostChildInRightSubtree=root.right;
        // Traverse to the leftmost node in the right subtree.
        while(leftmostChildInRightSubtree.left!=null)
        {
            leftmostChildInRightSubtree=leftmostChildInRightSubtree.left;
        }
        // Attach the left subtree to the leftmost node in the right subtree.
        leftmostChildInRightSubtree.left=leftChild;
        // Return the right subtree as the new root of the modified tree.
        return root.right;
    }
    public static TreeNode deleteNode(TreeNode root,int key)
    {
        if(root==null) return null;
        //If the node to be deleted is the root node, use the connector function to replace the root.
        if(root.data==key) return connector(root);
        // Traverse the tree to find the node to be deleted.
        TreeNode node=root;
        while(node!=null)
        {
            //If the key to be deleted is smaller than the current node's data,
            //move to the left subtree.
            if(node.data>key)
            {
                if(node.left!=null && node.left.data==key)
                {
                    node.left=connector(node.left);
                    break;
                }
                else
                    node=node.left;
            }
            else
            {
                if(node.right!=null && node.right.data==key)
                {
                    node.right=connector(node.right);
                    break;
                }
                else
                    node=node.right;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root = deleteNode(root, 3);
    }
}
