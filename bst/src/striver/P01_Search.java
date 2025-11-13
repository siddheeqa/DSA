package striver;

public class P01_Search {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { data = val; left = null; right = null; }
    }
    public static TreeNode searchBST(TreeNode root,int val)
    {
        while(root!=null && root.data!=val)
        {
            root=(root.data>val)?root.left:root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode result = searchBST(root, 2);
        if (result != null) {
            System.out.println("Node found with value: " + result.data);
        } else {
            System.out.println("Node not found");
        }
    }
}
