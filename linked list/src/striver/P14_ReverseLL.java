package striver;

public class P14_ReverseLL {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            val = 0;
            next = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
        }

        ListNode(int data1, ListNode next1) {
            val = data1;
            next = next1;
        }
    }
    public static ListNode recursive(ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursive(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
        public static ListNode iterative(ListNode head)
        {
            ListNode temp = head;
            ListNode prev = null;
            while(temp!=null)
            {
                ListNode front=temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
            }
        return prev;
    }
        public static void printLinkedList(ListNode head) {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        public static void main(String[] args) {
            // Create a linked list with
            // Values 1, 3, 2, and 4
            ListNode head = new ListNode(1);
            head.next = new ListNode(3);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(4);

            // Print the original linked list
            System.out.print("Original Linked List: ");
            printLinkedList(head);

            head = recursive(head);
            // Print the reversed linked list
            System.out.print("Reversed Linked List: ");
            printLinkedList(head);
        }
}
