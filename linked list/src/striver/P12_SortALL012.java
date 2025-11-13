package striver;

import java.util.List;

public class P12_SortALL012 {
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
    public static ListNode optimal(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // Dummy nodes to point to heads of
        // three lists
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        //Pointers to current last nodes of three Lists
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            } else if (temp.val == 2) {
                two.next = temp;
                two = temp;
            }
            temp=temp.next;
        }
            //connects the three list together
            // Connect the three lists together
            zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
            one.next = twoHead.next;
            two.next = null;
            // New head of the sorted list
            ListNode newHead = zeroHead.next;

            // Delete dummy nodes
            return newHead;

    }
    public static ListNode brute(ListNode head)
    {
        //Initialize counts
        int c0=0,c1=0,c2=0;
        ListNode temp=head;
        while(temp!=null)
        {
            if (temp.val == 0)
                c0++;
            else if (temp.val == 1)
                c1++;
            else if (temp.val == 2)
                c2++;
            temp = temp.next;
        }
        temp=head;
        while (temp != null) {
            if (c0 > 0) {
                temp.val = 0;
                c0--;
            } else if (c1 > 0) {
                temp.val = 1;
                c1--;
            } else if (c2 > 0) {
                temp.val = 2;
                c2--;
            }
            temp = temp.next;
        }
        return head;
    }
    public static ListNode newNode(int data) {
        ListNode node = new ListNode(data);
        return node;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Creating a linked list
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(0);
        head.next.next.next = newNode(1);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(0);
        head.next.next.next.next.next.next = newNode(1);
        System.out.print("Original list: ");
        printList(head);
        head = optimal(head);
        System.out.print("Sorted list: ");
        printList(head);
    }
}
