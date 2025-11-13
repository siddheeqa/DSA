package striver;

public class P07_DeletionDLL {
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
    //where node not equal to head
    public static void deleteNode(Node temp)
    {
        Node prevN=temp.prev;
        Node nextN=temp.next;
        if(nextN==null)
        {
            prevN.next=null;
            temp.prev=null;
        }
        else {
            prevN.next = nextN;
            nextN.prev = prevN;
            temp.next = null;
            temp.prev = null;
        }
    }
    public static Node deleteKElement(Node head,int k)
    {
        if(head==null || k==0) return head;
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            count++;
            if(count==k) break;
            temp=temp.next;
        }
        if(temp == null) return head; // k > length
        Node prevN=temp.prev;
        Node nextN=temp.next;
        //DLL have only one element
        if(prevN==null && nextN==null)
            return null;
        //If it is head
        else if(prevN==null)
        {
            nextN.prev=null;
            head=nextN;
        }
        //If it is tail
        else if(nextN==null) {
            prevN.next=null;
        }
        else {
            prevN.next = nextN;
            nextN.prev = prevN;
        }
        temp.next=null;
        temp.prev=null;
        return head;
    }
    public static Node deleteTail(Node head)
    {
        if(head==null || head.next==null) return null;
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        Node newTail=temp.prev;
        newTail.next=null;
        temp.prev=null;
        return head;
    }
    public static Node deleteHead(Node head)
    {
        if(head==null || head.next==null) return null;
        //preserve head to make it null
        Node prev=head;
        head=head.next;
        head.prev=null;
        prev.next=null;
        return head;
    }
    // Helper method to print DLL forward
    public static void printForward(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
        public static void main (String[]args){
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
            printForward(head);

            // Delete head
            head = deleteHead(head);
            System.out.print("After deleting head: ");
            printForward(head);

            // Delete tail
            head = deleteTail(head);
            System.out.print("After deleting tail: ");
            printForward(head);

            // Delete 2nd element
            head = deleteKElement(head, 2);
            System.out.print("After deleting 2nd element: ");
            printForward(head);
            deleteNode(head.next);
            System.out.print("After deleting node by reference (current head): ");
            printForward(head);

        }
    }

