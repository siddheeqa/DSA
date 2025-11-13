package striver;

import java.util.*;

public class P14_LevelOrder {
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
    public static class Tuple
    {
        TreeNode node;
        int x;//vertical distance
        int y;//Level
        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root)
    {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        // TreeMap to store the nodes at each vertical distance
        //(vertical,level)
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> nodesMap=new TreeMap<>();
        // Queue for BFS traversal (stores node along with its x and y coordinates)
        Queue<Tuple> queue=new LinkedList<>();
        queue.offer(new Tuple(root,0,0));
        while (!queue.isEmpty())
        {
            Tuple tuple=queue.poll();
            TreeNode node=tuple.node;
            int x=tuple.x;
            int y=tuple.y;
            // Add the node's value to the map at the correct x and y
            nodesMap.putIfAbsent(x,new TreeMap<>());
            nodesMap.get(x).putIfAbsent(y,new PriorityQueue<>());
            nodesMap.get(x).get(y).offer(node.data);
            if(node.left!=null)
            {
                queue.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null)
            {
                queue.offer(new Tuple(node.right,x+1,y+1));
            }
        }
        // Prepare the result by sorting keys and compiling nodes
        for(TreeMap<Integer,PriorityQueue<Integer>> map:nodesMap.values())
        {
            List<Integer> column=new ArrayList<>();
            for(PriorityQueue<Integer> nodes:map.values())
            {
                while (!nodes.isEmpty())
                {
                    //Removing elements one by one from the PriorityQueue (so they come out in sorted order)
                    column.add(nodes.poll());
                }
            }
            res.add(column);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = verticalTraversal(root);

        System.out.println("Vertical Traversal:");
        for (List<Integer> column : result) {
            System.out.println(column);
        }
    }
}
