package striver;

public class P05_Search {
    static class Node
    {
        public int data;
        public Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
        public Node(int data, Node next)
        {
            this.data=data;
            this.next=next;
        }
    }
    public static boolean search(Node head,int val)
    {
        Node temp=head;
        while (temp!=null)
        {
            if(temp.data==val) return true;
            temp=temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        int val = 3;  // Element to be checked for presence in the linked list
        System.out.print(search(head, val));
    }
}
