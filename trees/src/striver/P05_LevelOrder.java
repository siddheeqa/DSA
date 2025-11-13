package striver;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P05_LevelOrder {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { data = val; left = null; right = null; }
    }
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size= queue.size();
            List<Integer> level=new ArrayList<>();
            for(int i=1;i<=size;i++)
            {
                TreeNode node=queue.poll();
                level.add(node.data);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> result = levelOrder(root);
        System.out.println("Level Order Traversal of Tree:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
