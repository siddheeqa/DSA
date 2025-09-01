package striver;

public class P05_ImplementStackUsingLinkedList {
    static class Node
    {
        int val;
        Node next;
        Node(int element)
        {
            val=element;
            next=null;
        }
    }
    //Time Complexity: O(1) for push, pop, size,isEmpty, peek operations.
    //Space Complexity: O(N)
    static class LinkedListStack
    {
        //Top of the stack
        private Node head;
        //stack size
        private int size;
        //constructor
        public LinkedListStack()
        {
            head=null;
            size=0;
        }
        public void push(int x)
        {
            Node element=new Node(x);
            element.next=head;
            //updating the top
            head=element;
            size++;
        }
        public int pop()
        {
            if(head==null)
                return -1;
            int value=head.val;
            Node temp=head;
            //update the top to next node
            head=head.next;
            temp=null;
            size--;
            return value;
        }
        public int top()
        {
            if(head==null)
                return -1;
            return head.val;
        }
        public boolean isEmpty()
        {
            return (size==0);
        }
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());  // should print 30
        System.out.println("Popped element: " + stack.pop()); // removes 30
        System.out.println("Top element after pop: " + stack.top()); // should print 20
        stack.pop(); // removes 20
        stack.pop(); // removes 10

        System.out.println("Is stack empty now? " + stack.isEmpty());
        System.out.println("Pop from empty stack: " + stack.pop()); // should return -1
    }
}
