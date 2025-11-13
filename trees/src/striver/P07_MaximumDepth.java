package striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P07_MaximumDepth {
    public static int iterative(TreeNode root)
    {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty())
        {
            int size= queue.size();
            for(int i=1;i<=size;i++)
            {
                TreeNode node=queue.poll();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            level++;
        }
        return level;
    }
    public static int recursive(TreeNode root)
    {
        if(root==null)
            return 0;
        //Recursively find the depth of the left and right subtrees
        int left=recursive(root.left);
        int right=recursive(root.right);
        // The depth of the tree is 1 current node + the maximum depth of the subtrees
        return 1+Math.max(left,right);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Maximum Depth: " + iterative(root));
    }
}
