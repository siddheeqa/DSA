package striver;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.List;

public class P03_FloorAndCeil {
    public static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int val) {
            data = val;
            left = right = null;
        }
    }
    public static List<Integer> floorCeilOfBST(TreeNode root,int key)
    {
        int floor=-1;
        int ceil=-1;
        // Find the floor value
        TreeNode current=root;
        while(current!=null)
        {
            if(current.data==key)
            {
                floor=current.data;
                break;
            }
            else if(current.data>key)
            {
                current=current.left;
            }
            else
            {
                floor=current.data;
                current=current.right;
            }
        }
        // Find the ceil value
        current=root;
        while(current!=null)
        {
            if(current.data==key)
            {
                ceil=current.data;
                break;
            }
            else if(current.data>key)
            {
                ceil=current.data;
                current=current.left;
            }
            else
                current=current.right;
        }
        return Arrays.asList(floor,ceil);
    }
    public static void main(String[] args) {
        // Creating a sample BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        int key = 11;
        List<Integer> result = floorCeilOfBST(root, key);
        System.out.println("Floor: " + result.get(0) + ", Ceil: " + result.get(1));
    }
}
