package striver;

public class P10_AddTwoNumberLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static Node addTwoNumbers(Node l1,Node l2)
    {
        Node dummy=new Node(0);
        Node temp=dummy;
        int carry=0;
        while(l1!=null || l2!=null|| carry!=0)
        {
            int sum=carry;
            if(l1!=null)
            {
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+= l2.data;
                l2=l2.next;
            }
            carry=sum/10;
            //Create a new node with the digit value
            Node node=new Node(sum%10);
            temp.next=node;
            temp=temp.next;
        }
        return dummy.next;
    }
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node l1 = new Node(2, new Node(4, new Node(3)));

        // Number 2: 465 represented as 5 -> 6 -> 4
        Node l2 = new Node(5, new Node(6, new Node(4)));

        System.out.print("First number: ");
        printList(l1);

        System.out.print("Second number: ");
        printList(l2);

        Node result = addTwoNumbers(l1, l2);

        System.out.print("Sum: ");
        printList(result);
    }
}
