package striver;

import java.util.Stack;

public class P09_ReverseDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public static Node optimal(Node head)
    {
        if(head==null || head.next==null) return head;
        Node prevP=null;
        Node current=head;
        while(current!=null)
        {
            prevP=current.prev;
            current.prev=current.next;
            current.next=prevP;
            current=current.prev;
        }
        //The final node in the original list becomes the new head after reversal
        return prevP.prev;
    }
    public static Node brute(Node head)
    {
        if(head==null) return null;
        Stack<Integer> stack=new Stack<>();
        Node temp=head;
        while(temp!=null)
        {
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null)
        {
            temp.data=stack.pop();
            temp=temp.next;
        }
        return head;
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
        public static void main(String[] args) {
            // Create DLL: 10 <-> 20 <-> 30 <-> 40 <-> 50
            Node head = new Node(10);
            Node second = new Node(20);
            Node third = new Node(30);
            Node fourth = new Node(40);
            Node fifth = new Node(50);

            head.next = second;
            second.prev = head;

            second.next = third;
            third.prev = second;

            third.next = fourth;
            fourth.prev = third;

            fourth.next = fifth;
            fifth.prev = fourth;

            System.out.print("Original DLL: ");
            printList(head);

            // Reverse DLL using brute method
            head = optimal(head);

            System.out.print("Reversed DLL: ");
            printList(head);
    }
}
