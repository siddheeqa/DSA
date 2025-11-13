package striver;

public class P01_Representation {
    static class Node {
        int data;
        // Reference to the left child node
        Node left;
        // Reference to the right child node
        Node right;
        public Node(int key) {
            data = key;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
    }
}
