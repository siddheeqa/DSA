package striver;

import java.util.Stack;

public class P15_CheckLLPalindrome {
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
    public static boolean optimal(ListNode head)
    {
        if (head == null || head.next == null) {
            return true;
        }
        //Initialize two pointers, slow and fast, to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = recursive(slow.next);
        slow.next = newHead;
        ListNode first = head;
        ListNode second = newHead;
        boolean palindrome = true;
        while (second!=null) {
            if (first.val != second.val) {
                palindrome=false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        slow.next=recursive(newHead);
        return palindrome;
    }
    public static boolean brute(ListNode head)
    {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);
        if (optimal(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
