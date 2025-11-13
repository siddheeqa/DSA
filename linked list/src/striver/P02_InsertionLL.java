package striver;

public class P02_InsertionLL {
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
    public static Node insertBeforeVal(Node head,int val,int newVal)
    {
        if(head==null)
            return head;
        if(head.data==val)
            return new Node(newVal,head);
        Node temp=head;
        while(temp.next!=null)
        {
            //ensure to stay at previous Node
            if(temp.next.data==val)
            {
                Node newNode=new Node(newVal,temp.next);
                temp.next=newNode;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public static Node insertAtK(Node head,int val,int k)
    {
        if(head==null) {
            if(k==1)
                return new Node(val);
            else
                //insertion is not possible
                return head;
        }
        //if head is not null
        if(k==1)
            return new Node(val,head);
        int count=0;
        Node temp=head;
        while(temp!=null)
        {
            count++;
            if(count==k-1)
            {
                Node newNode=new Node(val,temp.next);
                temp.next=newNode;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public static Node insertAtTail(Node head,int val)
    {
        if(head==null) return new Node(val);
        Node temp=head;
        //I need last Node address
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        Node newNode=new Node(val);
        temp.next=newNode;
        return head;
    }
    public static Node insertAtHead(Node head,int x)
    {
        Node newHead=new Node(x);
        newHead.next=head;
        return newHead;
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
    public static void main(String[] args) {
        // Initial list: 20 -> 30 -> 40
        Node head = new Node(20);
        head.next = new Node(30);
        head.next.next = new Node(40);

        System.out.println("Original List: ");
        printLL(head);

        // 1. Insert at Head
        head = insertAtHead(head, 10);
        System.out.println("After inserting 10 at head: ");
        printLL(head);

        // 2. Insert at Tail
        head = insertAtTail(head, 50);
        System.out.println("After inserting 50 at tail: ");
        printLL(head);

        // 3. Insert at k=3 (insert 25 at position 3)
        head = insertAtK(head, 25, 3);
        System.out.println("After inserting 25 at position 3: ");
        printLL(head);

        // 4. Insert before value = 30 (insert 15 before 30)
        head = insertBeforeVal(head, 30, 15);
        System.out.println("After inserting 15 before 30: ");
        printLL(head);
    }

}
