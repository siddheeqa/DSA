package striver;

import java.util.ArrayList;
import java.util.List;

public class P13_BoundaryTraversal {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void addLeftBoundary(TreeNode root, List<Integer> res)
    {
        TreeNode curr=root.left;
        while(curr!=null)
        {
            if(!isLeaf(curr))
            {
                res.add(curr.data);
            }
            if(curr.left!=null)
                curr=curr.left;
            else
                curr=curr.right;
        }
    }
    public static void addRightBoundary(TreeNode root, List<Integer> res)
    {
        TreeNode curr=root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr!=null)
        {
            if(!isLeaf(curr))
            {
                temp.add(curr.data);
            }
            if(curr.right!=null)
                curr=curr.right;
            else
                curr=curr.left;
        }
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
    }
    public static void addLeaves(TreeNode root,List<Integer> res)
    {
        if(isLeaf(root))
        {
            res.add(root.data);
            return;
        }
        if(root.left!=null)
            addLeaves(root.left,res);
        if(root.right!=null)
            addLeaves(root.right,res);
    }
    public static List<Integer> boundary(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        if(!isLeaf(root))
            res.add(root.data);
        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);
        return res;
    }
    public static void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> result = boundary(root);
        System.out.print("Boundary Traversal: ");
        printResult(result);
    }
}
