package striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P17_RightLeftView {
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
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                level.add(top.data);
                // Enqueue the left child if it exists
                if (top.left != null) {
                    q.add(top.left);
                }
                // Enqueue the right child if it exists
                if (top.right != null) {
                    q.add(top.right);
                }
            }
            // Add the current level to the result
            ans.add(level);
        }
        return ans;
    }
    public static List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        // Get the level order traversal of the tree
        List<List<Integer>> levelTraversal = levelOrder(root);
        // Iterate through each level and add the last element to the result
        for (List<Integer> level : levelTraversal) {
            res.add(level.get(level.size() - 1));
        }
        return res;
    }
    public static List<Integer> leftSideView(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        // Get the level order traversal of the tree
        List<List<Integer>> levelTraversal = levelOrder(root);
        // Iterate through each level and add the first element to the result
        for (List<Integer> level : levelTraversal) {
            res.add(level.get(0));
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        List<Integer> rightView = rightSideView(root);
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();
        List<Integer> leftView = leftSideView(root);
        System.out.print("Left View Traversal: ");
        for (int node : leftView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
