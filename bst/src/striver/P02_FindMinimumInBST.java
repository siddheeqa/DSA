package striver;

import java.util.ArrayList;

public class P02_FindMinimumInBST {
    public static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }
    public static int optimal(Node root)
    {
        if(root==null) return -1;
        Node temp=root;
        while (temp.left!=null)
            temp=temp.left;
        return temp.data;
    }
    public static int better(Node root)
    {
        if(root.left==null) return root.data;
        return better(root.left);
    }
    public static void inorder(Node root,ArrayList<Integer> res)
    {
        if(root==null)
            return;
        inorder(root.left,res);
        res.add(root.data);
        inorder(root.right,res);
    }
    public static int brute(Node root)
    {
        if(root==null) return -1;
        ArrayList<Integer> res=new ArrayList<>();
        inorder(root,res);
        return res.get(0);
    }
    public static void main(String[] args) {

            Node root = new Node(5);
            root.left = new Node(4);
            root.right = new Node(6);
            root.left.left = new Node(3);
            root.right.right = new Node(7);
            root.left.left.left = new Node(1);
            System.out.println(brute(root));
        }
    }

