package striver;

public class P06_DLLRepresentation {
    static class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data=data;
            this.next=null;
            this.prev=null;
        }
        Node(int data,Node next,Node prev)
        {
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
    }
    // Print DLL forward (head -> tail)
    public static void printForward(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // Find tail node given head
    public static Node getTail(Node head) {
        if (head == null) return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp; // last node
    }
    public static void printBackward(Node head) {
        Node tail = getTail(head); // find last node
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Create nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Link nodes
        first.next = second;
        second.prev = first;
        second.next = third;
        third.prev = second;

        // Print forward
        System.out.print("Forward: ");
        printForward(first);

        // Print backward (automatically finds tail)
        System.out.print("Backward: ");
        printBackward(first);
    }
}
