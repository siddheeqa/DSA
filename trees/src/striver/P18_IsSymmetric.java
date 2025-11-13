package striver;

public class P18_IsSymmetric {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean symmetry(TreeNode left,TreeNode right)
    {
        //Both nodes are null, so symmetric
        if(left==null && right==null) return true;
        //One of the nodes is null, so not symmetric
        if(left==null || right==null)
            return false;
        return left.data==right.data && symmetry(left.left,right.right) && symmetry(left.right,right.left);
    }
    public static boolean isSymmetric(TreeNode root)
    {
        if(root==null) return true;
        return symmetry(root.left,root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
