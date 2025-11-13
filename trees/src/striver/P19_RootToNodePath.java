package striver;

import java.util.ArrayList;
import java.util.List;

public class P19_RootToNodePath {
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
    public static void dfs(TreeNode node,List<Integer> path,List<List<Integer>> allPaths)
    {
        if(node==null) return;
        path.add(node.data);
        // Add the current node's data to the path
        if(node.left==null && node.right==null)
            allPaths.add(new ArrayList<>(path));
        else
        {
            dfs(node.left,path,allPaths);
            dfs(node.right,path,allPaths);
        }
        // Backtrack by removing the last node from the path
        path.remove(path.size()-1);
    }
    public static List<List<Integer>> allRootToLeaf(TreeNode root)
    {
        // List to store all root-to-leaf paths
        List<List<Integer>> allPaths=new ArrayList<>();
        // List to store the current path
        List<Integer> currentPath = new ArrayList<>();
        dfs(root,currentPath,allPaths);
        return allPaths;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(allRootToLeaf(root));
    }
}
