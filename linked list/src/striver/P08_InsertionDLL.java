package striver;

public class P08_InsertionDLL {

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
    public static Node insertBeforeHead(Node head, int val) {
        Node newNode = new Node(val, head, null);
        if (head != null) head.prev = newNode;
        return newNode;
    }

    public static Node insertBeforeTail(Node head, int val) {
        if (head == null) return new Node(val, null, null);

        Node temp = head;
        while (temp.next != null) temp = temp.next;

        Node prevN = temp.prev;
        Node newNode = new Node(val, temp, prevN);

        if (prevN != null) prevN.next = newNode;
        else head = newNode; // only one node existed
        temp.prev = newNode;

        return head;
    }

    public static Node insertBeforeKElement(Node head, int k, int val) {
        if (head == null) {
            if (k == 1) return new Node(val, null, null);
            else return head; // cannot insert
        }

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) break;
            temp = temp.next;
        }

        if (temp == null) return head; // k > length

        Node prev = temp.prev;
        Node newNode = new Node(val, temp, prev);

        if (prev != null) prev.next = newNode;
        else head = newNode; // inserting at head

        temp.prev = newNode;

        return head;
    }

    public static void printForward(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void printBackward(Node head) {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) temp = temp.next; // move to tail
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Initial DLL: 10 <-> 20 <-> 30
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        System.out.print("Original DLL: ");
        printForward(head);

        // Insertions
        head = insertBeforeHead(head, 5);
        System.out.print("After inserting 5 before head: ");
        printForward(head);

        head = insertBeforeTail(head, 25);
        System.out.print("After inserting 25 before tail: ");
        printForward(head);

        head = insertBeforeKElement(head, 3, 15);
        System.out.print("After inserting 15 before 3rd element: ");
        printForward(head);
    }
}
