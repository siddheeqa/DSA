package striver;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P02_Preorder {
    static public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    public static List<Integer> iterative(TreeNode root)
    {
        List<Integer> preorder=new ArrayList<>();
        if(root==null)
            return preorder;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        // Perform iterative preorder traversal
        while (!stack.empty())
        {
            root=stack.pop();
            preorder.add(root.data);
            if(root.right!=null)
                stack.push(root.right);
            if(root.left!=null)
                stack.push(root.left);
        }
        return preorder;
    }
    public static void recursiveRecur(TreeNode root, List<Integer> ans)
    {
        if(root==null) return;
        ans.add(root.data);
        recursiveRecur(root.left,ans);
        recursiveRecur(root.right,ans);
    }
    public static List<Integer> recursive(TreeNode root)
    {
        List<Integer> ans=new ArrayList<>();
        recursiveRecur(root,ans);
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> result = recursive(root);
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
