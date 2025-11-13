package striver;

public class P18_AddOneToLL {
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
    public static int helper(ListNode temp)
    {
        if(temp==null) return 1;
        int carry=helper(temp.next);
        temp.val=temp.val+carry;
        if(temp.val<10) return 0;
        temp.val=0;
        return 1;
    }
    public static ListNode recursive(ListNode head)
    {
        int carry=helper(head);
        if(carry==1)
        {
            ListNode newNode=new ListNode(1);
            newNode.next=head;
            return newNode;
        }
        return head;
    }
    public static ListNode iterative(ListNode head)
    {
        head=reverse(head);
        //create dummy node
        ListNode current=head;
        int carry=1;
        while(current!=null)
        {
            int sum=current.val+carry;
            //update carry
            carry=sum/10;
            current.val=sum%10;
            if(carry==0)
                break;
            //If we've reached the end of the list and there's still a carry, add a new node with the carry value
            if(current.next==null && carry!=0)
            {
                current.next=new ListNode(carry);
                break;
            }
            current=current.next;
        }
        head=reverse(head);
        return head;
    }
    public static ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1 = recursive(head1);
        System.out.print("Result after adding one: ");
        printList(head1);
    }
}
