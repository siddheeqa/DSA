package striver;
import java.util.ArrayList;
import java.util.List;

public class P06_FindKthSmallestAndSmallest {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { data = val; left = null; right = null; }
    }
    private static void inorderTraversal(TreeNode node, List<Integer> values) {
        if (node != null) {
            inorderTraversal(node.left, values);
            values.add(node.data);
            inorderTraversal(node.right, values);
        }
    }
    public static List<Integer> kLargeSmall(TreeNode root,int k)
    {
        List<Integer> values=new ArrayList<>();
        inorderTraversal(root,values);
        int kth_smallest=values.get(k-1);
        int kth_largest=values.get(values.size()-k);
        List<Integer> result=new ArrayList<>();
        result.add(kth_smallest);
        result.add(kth_largest);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        int k = 1;
        List<Integer> result =kLargeSmall(root, k);

        System.out.println(result);
    }
}
