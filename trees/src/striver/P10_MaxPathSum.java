package striver;

public class P10_MaxPathSum {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    public static int findMaxPathSum(TreeNode root,int[] maxi)
    {
        if(root==null)
            return 0;
        //Calculate the maximum path sum for the left and right subtrees
        int leftMaxPath=Math.max(0,findMaxPathSum(root.left,maxi));
        int rightMaxPath=Math.max(0,findMaxPathSum(root.right,maxi));
        //Update the overall maximum path sum including the current node
        maxi[0]=Math.max(maxi[0],leftMaxPath+rightMaxPath+ root.data);
        return Math.max(leftMaxPath,rightMaxPath)+root.data;
    }
    public static int maxPathSum(TreeNode root)
    {
        int[] maxi = {Integer.MIN_VALUE};
        findMaxPathSum(root, maxi);
        // Return the final maximum path sum
        return maxi[0];
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }

}
