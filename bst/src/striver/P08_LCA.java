package striver;

import java.util.ArrayList;
import java.util.List;

public class P08_LCA {
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
    public static TreeNode optimal(TreeNode root,int p,int q)
    {
        if(root==null) return null;
        int curr=root.data;
        //If both nodes are greater than root
        if(curr<p && curr<q)
            return optimal(root.right,p,q);
        //If both nodes are smaller than root
        if(curr>p && curr>q)
            return optimal(root.left,p,q);
        return root;
    }
    public static boolean getPath(TreeNode root,List<Integer> path,int x)
    {
        while(root!=null)
        {
            path.add(root.data);
            if(root.data==x)
                return true;
            else if(x<root.data)
                root=root.left;
            else
                root=root.right;
        }
        // If we reach null, x was not found — clear path and return false
        path.clear();
        return false;
    }
    public static TreeNode brute(TreeNode root,int p,int q)
    {
        List<Integer> path1=new ArrayList<>();
        List<Integer> path2=new ArrayList<>();
        //Find paths from the root to the given nodes
        if(!getPath(root,path1,p) || !getPath(root,path2,q))
            return null;
        //Find last common element in tha paths
        int i=0;
        while(i<path1.size() && i< path2.size() && path1.get(i).equals(path2.get(i)))
        {
            i++;
        }
        return new TreeNode(path1.get(i-1));
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode ans =brute(root, 5, 1);
        if (ans != null) {
            System.out.println("LCA(5, 1) = " + ans.data);
        } else {
            System.out.println("LCA(5, 1) is not present in the tree");
        }
        ans = brute(root, 5, 4);
        if (ans != null) {
            System.out.println("LCA(5, 4) = " + ans.data);
        } else {
            System.out.println("LCA(5, 4) is not present in the tree");
        }
    }
}
