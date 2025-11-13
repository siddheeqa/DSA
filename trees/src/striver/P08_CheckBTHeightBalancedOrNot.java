package striver;

public class P08_CheckBTHeightBalancedOrNot {
    public static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int val) {
            data = val;
            left = right = null;
        }
        public static int recursionRecur(TreeNode root)
        {
            if(root==null) return 0;
            int left=recursionRecur(root.left);
            if(left==-1) return -1;
            int right=recursionRecur(root.right);
            if(right==-1) return -1;
            if(Math.abs(left-right)>1) return -1;
            return 1+Math.max(left,right);
        }
        public static boolean recursion(TreeNode root)
        {
            return recursionRecur(root)!=-1;
        }
        public static int height(TreeNode root)
        {
            if(root==null)
                return 0;
            //Recursively find the depth of the left and right subtrees
            int left=height(root.left);
            int right=height(root.right);
            // The depth of the tree is 1 current node + the maximum depth of the subtrees
            return 1+Math.max(left,right);
        }
        public static boolean brute(TreeNode root)
        {
            if(root==null) return true;
            int left=height(root.left);
            int right=height(root.right);
            // Check if current node is balanced
            if(Math.abs(left-right)>1) return false;
            // Recursively check if left and right subtrees are balanced
            return brute(root.left) && brute(root.right);
        }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        if (recursion(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
    }
}
