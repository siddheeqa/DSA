package striver;

public class P04_Length {
    static class Node{
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
    public static int length(Node head)
    {
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[]arr={2,5,8,7};
        Node head = new Node(arr[0]);
        head.next= new Node(arr[1]);
        head.next.next= new Node(arr[2]);
        head.next.next.next= new Node(arr[3]);
        // Print the length of the linked list
        System.out.println(length(head));
    }
}
