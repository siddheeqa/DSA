package striver;

public class P20_LowestCommonAncestor {
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
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null || root==p || root==q)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //Result
        if(left==null) return right;
        else if(right==null) return left;
        // Both left and right are not null, we found our result
        else
            return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.data);
    }
}
