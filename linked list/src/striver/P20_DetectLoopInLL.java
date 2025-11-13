package striver;

import java.util.HashMap;

public class P20_DetectLoopInLL {
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
    public static boolean optimal(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
    public static boolean brute(ListNode head)
    {
        ListNode temp=head;
        // Create a map to keep track of
        // Encountered nodes
        HashMap<ListNode,Integer> nodeMap=new HashMap<>();
        while(temp!=null)
        {
            if(nodeMap.containsKey(temp))
                return true;
            //Store the current node in the map
            nodeMap.put(temp,1);
            temp=temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;
        if (optimal(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
