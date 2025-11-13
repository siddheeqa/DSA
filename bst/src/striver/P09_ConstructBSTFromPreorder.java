package striver;

import java.util.*;
/*
public class P09_ConstructBSTFromPreorder {
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
    public static TreeNode buildTree(int[] preorder,Map<Integer,Integer> inMap,int preStart,int preEnd,int inStart,int inEnd)
    {
        // Base case: if the start indices exceed the end indices, return null
        if (preStart > preEnd || inStart > inEnd) return null;

    }
    public static TreeNode better(List<Integer> preorder)
    {
        List<Integer> inorder = new ArrayList<>(preorder);
        Collections.sort(inorder);
        // Create a map to store indices of elements in the inorder traversal
        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.size();i++)
            inmap.put(inorder.get(i),i);
        // Convert list to array for easier index access
        int[] preorderArr = preorder.stream().mapToInt(i -> i).toArray();

        // Helper function to build the tree
        return buildTree(preorderArr, inMap, 0, preorderArr.length - 1, 0, inorder.size() - 1);
    }
    public static TreeNode brute(List<Integer> preorder)
    {
        if(preorder.isEmpty()) return null;
        TreeNode root=new TreeNode(preorder.get(0));
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        for(int i=1;i<preorder.size();i++)
        {
            TreeNode node=stack.peek();
            TreeNode child=new TreeNode(preorder.get(i));
            //Either stack is empty → new node becomes the right child of last popped node
            //Or top of stack > new value → new node becomes left child of stack top
            while(!stack.isEmpty() && stack.peek().data < preorder.get(i))
            {
                node=stack.pop();
            }
            if(node.data<preorder.get(i))
                node.right=child;
            else
                node.left=child;
            stack.push(child);
        }
        return root;
    }
    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        List<Integer> preorder = Arrays.asList(8, 5, 1, 7, 10, 12);
        TreeNode root = brute(preorder);
        // Print the constructed BST
        inorderTraversal(root);
    }
}
 */
