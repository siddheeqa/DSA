package striver;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P03_Inorder {
    static public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    public static List<Integer> iterative(TreeNode root)
    {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        List<Integer> inorder=new ArrayList<>();
        while(true)
        {
            if(node!=null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if (stack.isEmpty())
                    break;
                node=stack.pop();
                inorder.add(node.data);
                node=node.right;
            }
        }
        return inorder;
    }
    public static void recursiveRecur(TreeNode root, List<Integer> ans)
    {
        if(root==null) return;
        recursiveRecur(root.left,ans);
        ans.add(root.data);
        recursiveRecur(root.right,ans);
    }
    public static List<Integer> recursive(TreeNode root)
    {
        List<Integer> ans=new ArrayList<>();
        recursiveRecur(root,ans);
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> result = recursive(root);
        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
