package striver;

import java.util.*;

public class P06_PreInPost {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    // Helper class to store a TreeNode and its traversal state
    public static class NodeState {
        TreeNode node;
        int state;

        NodeState(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static List<List<Integer>> treeTraversal(TreeNode root)
    {
        // Lists to store the traversals
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(root==null) return Arrays.asList(pre,in,post);
        Stack<NodeState> stack=new Stack<>();
        stack.push(new NodeState(root,1));
        while (!stack.isEmpty())
        {
            NodeState top=stack.pop();
            TreeNode node=top.node;
            int state=top.state;
            // Process the node based on its state
            if(state==1)
            {
                pre.add(node.data);
                // Change state to 2 (inorder) for this node
                stack.push(new NodeState(node,2));
                if(node.left!=null)
                    stack.push(new NodeState(node.left,1));
            }
            else if(state==2)
            {
                in.add(node.data);
                // Change state to 3 (postorder) for this node
                stack.push(new NodeState(node,3));
                if(node.right!=null)
                    stack.push(new NodeState(node.right,1));
            }
            else {
                post.add(node.data);
            }
        }
        return Arrays.asList(pre,in,post);
    }
        public static void main(String[] args) {
            // Creating a sample binary tree
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            List<List<Integer>> traversals = treeTraversal(root);
            System.out.print("Preorder traversal: ");
            for (int val : traversals.get(0)) System.out.print(val + " ");
            System.out.println();
            System.out.print("Inorder traversal: ");
            for (int val : traversals.get(1)) System.out.print(val + " ");
            System.out.println();
            System.out.print("Postorder traversal: ");
            for (int val : traversals.get(2)) System.out.print(val + " ");
            System.out.println();
    }
}
