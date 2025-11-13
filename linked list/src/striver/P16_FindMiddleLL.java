package striver;

public class P16_FindMiddleLL {
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
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode brute(ListNode head)
    {
        ListNode temp=head;
        int count=0;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        int midPosition = (count) / 2 + 1;
        temp=head;
        while(temp!=null)
        {
            midPosition--;
            if(midPosition==0)
                break;
            temp=temp.next;
        }
        return temp;
    }
    public static void printLinkedList(ListNode head) {
        ListNode temp = head;

        // Traverse the linked list and print each node's value
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
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
            ListNode middleNode = optimal(head);
            printLinkedList(head);
            System.out.println("The middle node is: " + middleNode.val);
        }
    }
