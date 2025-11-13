package striver;

import java.util.*;

public class P15_TopView {
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
    public static class Pair{
        TreeNode key;
        int value;
        Pair(TreeNode key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }
    public static List<Integer> topView(TreeNode root)
    {
       List<Integer> ans=new ArrayList<>();
       if(root==null) return ans;
       // Map to store the top view nodes based on their vertical positions
       Map<Integer,Integer> map=new TreeMap<>();
       Queue<Pair> queue=new LinkedList<>();
       queue.add(new Pair(root,0));
       while(!queue.isEmpty())
       {
           Pair pair=queue.poll();
           TreeNode node=pair.key;
           int line=pair.value;
           // If the vertical position is not already in the map, add the node's data to the map
           if(!map.containsKey(line))
               map.put(line,node.data);
           if(node.left!=null)
               queue.add(new Pair(node.left,line-1));
           if(node.right!=null)
               queue.add(new Pair(node.right,line+1));
       }
        for (Integer value : map.values()) {
            ans.add(value);
        }
       return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> result = topView(root);
        System.out.println("Top View: " + result);
    }
}
