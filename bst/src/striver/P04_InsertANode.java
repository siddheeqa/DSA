package striver;

public class P04_InsertANode {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    public static TreeNode insertIntoBST(TreeNode node,int val)
    {
        // If the current node is NULL, create a new TreeNode with the given value
        if(node==null) return new TreeNode(val);
        if(val<node.data)
            node.left=insertIntoBST(node.left,val);
        else if(val>node.data)
            node.right=insertIntoBST(node.right,val);
        return node;
    }
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 5;
        TreeNode newRoot = insertIntoBST(root, val);
        printInOrder(newRoot);
    }
}
