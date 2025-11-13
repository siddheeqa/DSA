package striver;

import java.util.HashSet;
import java.util.List;

public class P19_IntersectionOfLL {
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
    public static ListNode optimal(ListNode headA, ListNode headB)
    {
        if(headA==null || headB==null) return null;
        // Initialize two pointers to traverse the lists
        ListNode temp1=headA;
        ListNode temp2=headB;
        // Traverse both lists until the pointers meet
        while(temp1!=temp2)
        {
            temp1=(temp1==null)?headB:temp1.next;
            temp2=(temp2==null)?headA:temp2.next;
        }
        return temp1;
    }
    public static ListNode collisionPoint(ListNode smallerListHead, ListNode longerListHead,int len)
    {
        ListNode temp1=smallerListHead;
        ListNode temp2=longerListHead;
        // Adjust the pointers to same level
        for(int i=0;i<len;i++)
            temp2=temp2.next;
        while(temp1!=temp2)
        {
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1;
    }
    public static ListNode better(ListNode headA, ListNode headB)
    {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int n1=0,n2=0;
        //Get the length of first LL
        while(temp1!=null)
        {
            n1++;
            temp1=temp1.next;
        }
        //Get the length of second LL
        while (temp2!=null)
        {
            n2++;
            temp2=temp2.next;
        }
        //Traverse the longer list and bring the pointers to same level
        if(n1<n2) return collisionPoint(headA,headB,n2-n1);
        return collisionPoint(headB,headA,n1-n2);
    }
    public static ListNode brute(ListNode headA, ListNode headB)
    {
        HashSet<ListNode> nodes_set=new HashSet<>();
        while (headA != null) {
            nodes_set.add(headA);
            headA = headA.next;
        }
        while (headB!=null)
        {
            if(nodes_set.contains(headB))
                return headB;
            headB=headB.next;
        }
        //No intersection found, return null
        return null;
    }
    public static void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        // Create common part: 4->5
        ListNode common = new ListNode(4, new ListNode(5));

        // Create first list: 1->2->3->4->5
        ListNode headA = new ListNode(1,
                new ListNode(2,
                        new ListNode(3, common)));

        // Create second list: 9->4->5
        ListNode headB = new ListNode(9, common);

        System.out.print("List A: ");
        printList(headA);
        System.out.print("List B: ");
        printList(headB);

        // Find intersection
        ListNode intersection = brute(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection Node: " + intersection.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}
