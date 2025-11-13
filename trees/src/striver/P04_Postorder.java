package striver;

import com.sun.source.tree.Tree;

import java.util.*;

public class P04_Postorder {
    static public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    public static List<Integer> iterative(TreeNode root)
    {
        List<Integer> postOrder=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null)  stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            postOrder.add(node.data);
            if(node.left!=null)
                stack.push(node.left);
            if(node.right!=null)
                stack.push(node.right);
        }
        Collections.reverse(postOrder);
        return postOrder;
    }
    public static void recursiveRecur(TreeNode root, List<Integer> ans)
    {
        if(root==null) return;
        recursiveRecur(root.left,ans);
        recursiveRecur(root.right,ans);
        ans.add(root.data);
    }
    public static List<Integer> recursive(TreeNode root)
    {
        List<Integer> ans=new ArrayList<>();
        recursiveRecur(root,ans);
        return ans;
    }
    static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> result = iterative(root);
        System.out.print("Postorder traversal: ");
        printList(result);
    }
}
