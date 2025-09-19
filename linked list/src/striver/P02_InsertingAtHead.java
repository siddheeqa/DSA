package striver;

public class P02_InsertingAtHead {
    static class Node{
        public int data;
        public Node next;
        public Node(int data, Node next)
        {
            this.data=data;
            this.next=next;
        }
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public static void printLL(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.data+"");
            head=head.next;
        }
        System.out.println();
    }
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public static Node insertAtHead(Node head,int x)
    {
        Node newHead=new Node(x);
        newHead.next=head;
        return newHead;
    }
    public static void main(String[] args) {
        int[] arr = {20, 30, 40};
        //value to insert
        int x=10;
        Node head=new Node(arr[0]);
        head.next=new Node(arr[1]);
        head.next.next=new Node(arr[2]);

        //print the original list
        System.out.println("Original List: ");
        printLL(head);

        //Insert at the head
        head=insertAtHead(head,x);

        System.out.println("List after inserting the given value at head: ");
        printLL(head);
    }
}
