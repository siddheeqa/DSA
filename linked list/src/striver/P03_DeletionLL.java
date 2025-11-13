
package striver;


public class P03_DeletionLL {
    static class Node
    {
        public int data;
        public Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
        public Node(int data,Node next)
        {
            this.data=data;
            this.next=next;
        }
    }
    public static Node deleteVal(Node head,int val)
    {
        if(head==null)
            return head;
        if(head.data==val) return head.next;
        Node temp=head;
        Node prev=null;
        while(temp!=null)
        {
            if(temp.data==val)
            {
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
    public static Node deleteKElement(Node head,int k)
    {
        if(head==null) return head;
        if(k==1) return head.next;
        int count=0;
        Node temp=head;
        Node prev=null;
        while(temp!=null)
        {
            count++;
            if(count==k)
            {
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
    public static Node deleteTail(Node head)
    {
        //check linked list have one node
        if(head==null || head.next==null) return null;
        //To stand before last node
        Node temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    public static Node deleteHead(Node head)
    {
        if(head==null) return null;
        head=head.next;
        return head;
    }
    public static void printLL(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

        public static void main(String[] args) {
            // Create Linked List: 10 -> 20 -> 30 -> 40 -> 50
            Node head = new Node(10);
            head.next = new Node(20);
            head.next.next = new Node(30);
            head.next.next.next = new Node(40);
            head.next.next.next.next = new Node(50);

            System.out.print("Original List: ");
            printLL(head);
            System.out.println();

            // 1. Delete Head
            head = deleteHead(head);  // removes 10
            System.out.print("After deleting head: ");
            printLL(head);
            System.out.println();

            // 2. Delete Tail
            head = deleteTail(head);  // removes 50
            System.out.print("After deleting tail: ");
            printLL(head);
            System.out.println();

            // 3. Delete k-th element (k=2 → removes 30)
            head = deleteKElement(head, 2);
            System.out.print("After deleting 2nd element: ");
            printLL(head);
            System.out.println();

            // 4. Delete by value (delete value = 40)
            head = deleteVal(head, 40);
            System.out.print("After deleting value 40: ");
            printLL(head);
            System.out.println();
        }

    }
