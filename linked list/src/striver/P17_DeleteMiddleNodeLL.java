package striver;

public class P17_DeleteMiddleNodeLL {
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
    public static ListNode optimal(ListNode head)
    {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static ListNode brute(ListNode head)
    {
        if (head == null || head.next == null)
            return null;
        ListNode temp=head;
        int count=0;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        int midPosition = (count) / 2 ;
        temp=head;
        while(temp!=null)
        {
            midPosition--;
            if(midPosition==0) {
                ListNode middle=temp.next;
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Creating a sample linked list:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original Linked List: ");
        printLL(head);
        head = optimal(head);
        System.out.print("Updated Linked List: ");
        printLL(head);
    }
}
