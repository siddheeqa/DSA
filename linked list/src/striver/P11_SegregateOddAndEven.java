package striver;

import java.util.ArrayList;
import java.util.List;

public class P11_SegregateOddAndEven {
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
        // Check if list is empty or has only one node
        if (head == null || head.next == null)
            return head;
        //Initialize pointers for odd and even nodes and keep track of the first even node
        ListNode odd=head;
        ListNode even=head.next;
        ListNode firstEven=head.next;
        while(even!=null && even.next!=null)
        {
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=firstEven;
        return head;
    }
    public static ListNode brute(ListNode head)
    {
        // Check if list is empty or has only one node
        if (head == null || head.next == null)
            return head;
        List<Integer> array = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null && temp.next!=null)
        {
            array.add(temp.val);
            temp=temp.next.next;
        }
        //If the traversal ends on a valid odd node
        if(temp!=null) array.add(temp.val);
        //Reset temp
        temp=head.next;
        while(temp!=null && temp.next!=null)
        {
            array.add(temp.val);
            temp=temp.next.next;
        }
        //If the traversal ends on a valid even node
        if(temp!=null) array.add(temp.val);

        //Reset temp
        temp=head;
        int i=0;
        while(temp!=null)
        {
            temp.val=array.get(i);
            temp=temp.next;
            i++;
        }
        return head;
    }
    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 6};
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        head.next.next.next.next.next = new ListNode(arr[5]);
        head = optimal(head);
        printLL(head);
    }
}
