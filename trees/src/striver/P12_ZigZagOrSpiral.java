package striver;
import java.util.*;

public class P12_ZigZagOrSpiral {
    public static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int val) { data = val; left = null; right = null; }
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean leftToRight=true;
        while(!queue.isEmpty())
        {
            // Get the number of nodes at the current level
            int size=queue.size();
            List<Integer> row=new ArrayList<>(Collections.nCopies(size, 0));
            // Traverse nodes at the current level
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                int index=leftToRight?i:(size-1-i);
                // Insert the node's value at the determined index
                row.set(index,node.data);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            // Switch the traversal direction for the next level
            leftToRight=!leftToRight;
            res.add(row);
        }
        return res;
    }
    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
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
        List<List<Integer>> result = zigzagLevelOrder(root);
        printResult(result);
    }
}
