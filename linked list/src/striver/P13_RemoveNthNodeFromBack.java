package striver;

import java.util.Arrays;
import java.util.List;

public class P13_RemoveNthNodeFromBack {
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
    public static ListNode optimal(ListNode head,int n)
    {
        ListNode fastp = head;
        ListNode slowp = head;
        //Move the fastp pointer N nodes ahead
        for (int i = 1; i <= n; i++) {
            fastp = fastp.next;
        }
        //If fastp becomes NULL the Nth node from the end is the head
        if (fastp == null) {
            return head.next;
        }
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }
        //Delete the Nth node from the end
        ListNode delNode = slowp.next;
        slowp.next = slowp.next.next;
        return head;
    }
    public static ListNode brute(ListNode head,int n)
    {
        if(head==null) return null;
        int count=0;
        ListNode temp=head;
        while (temp!=null)
        {
            count++;
            temp=temp.next;
        }
        // If N equals the total number of nodes delete the head
        if(count==n)
        {
            ListNode newHead = head.next;
            return newHead;
        }
        int res=count-n;
        temp=head;
        //Traverse to the node just before the one to delete
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }
        ListNode deleteNode=temp.next;
        temp.next=temp.next.next;
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
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;
        ListNode head = new ListNode(arr.get(0));
        head.next = new ListNode(arr.get(1));
        head.next.next = new ListNode(arr.get(2));
        head.next.next.next = new ListNode(arr.get(3));
        head.next.next.next.next = new ListNode(arr.get(4));

        head = optimal(head, N);
        printLL(head);
    }
}
