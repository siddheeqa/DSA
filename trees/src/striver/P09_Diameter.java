package striver;

public class P09_Diameter {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    public static int height2(TreeNode node,int[] diameter)
    {
        if(node==null)
            return 0;
        // Recursively calculate the height of left and right subtrees
        int[] lh=new int[1];
        int[] rh=new int[1];
        lh[0]=height2(node.left,diameter);
        rh[0]=height2(node.right,diameter);
        // Update the diameter with the maximum of current diameter
        diameter[0]=Math.max(diameter[0],lh[0]+rh[0]);
        // Return the height of the current node's subtree
        return 1+Math.max(lh[0],rh[0]);

    }
    public static int optimal(TreeNode root)
    {
        int[] diameter=new int[1];
        height2(root,diameter);
        return diameter[0];
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
    public static int brute(TreeNode root)
    {
        //Get the height of left and right subtrees
        if(root==null) return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        //Calculate diameter through the current node
        int currentDiameter=leftHeight+rightHeight;
        // Recursively calculate the diameter of left and right subtrees
        int leftDiameter=brute(root.left);
        int rightDiameter=brute(root.right);
        return Math.max(currentDiameter,Math.max(leftDiameter,rightDiameter));
    }
    public static void main(String[] args) {
        // Creating a test tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Diameter of the binary tree is: " + optimal(root));
    }
}
