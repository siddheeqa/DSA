package striver;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class P21_MaximumWidth {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            data = val;
            left = null;right = null;
        }
    }
    public static class Pair {
        TreeNode node;
        int index; // position index
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public static int widthOfBinaryTree(TreeNode root)
    {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty())
        {
            int size=queue.size();
            //Get the position of the front of nodes in the current level
            int mmin=queue.peek().index;
            //Store the first and last positions of nodes in the current level
            int first=0,last=0;
            //Process each node in the current level
            for(int i=0;i<size;i++)
            {
            //Calculate current position relative to the minimum position in the level
            int cur_id=queue.peek().index-mmin;
            TreeNode node=queue.peek().node;
            queue.poll();
            if(i==0)
                first=cur_id;
            if(i==size-1)
                last=cur_id;
            if(node.left!=null)
                queue.offer(new Pair(node.left,cur_id*2+1));
            if(node.right!=null)
                queue.offer(new Pair(node.right,cur_id*2+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        int maxWidth = widthOfBinaryTree(root);
        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }
}
