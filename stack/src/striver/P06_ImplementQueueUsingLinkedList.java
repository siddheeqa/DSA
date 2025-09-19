package striver;

public class P06_ImplementQueueUsingLinkedList {
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
    //structure to represent queue
    //Time Complexity: O(1)
    //Space Complexity: O(N)
    static class LinkedListQueue
    {
        //start of the queue
       private Node start;
       //end of the queue
       private Node end;
       private int size;
       //constructor
        public LinkedListQueue()
        {
            start=end=null;
            size=0;
        }
        public void push(int x)
        {
            Node element=new Node(x);
            if(start==null)
            {
                start=end=element;
            }
            else {
                end.next=element;
                //updating the end
                end=element;
            }
            size++;
        }
        public int pop()
        {
            //queue is empty
            if(start==null)
                return -1;
            int value=start.val;
            Node temp=start;
            //update the front temporarily
            start=start.next;
            temp=null;
            size--;
            return value;
        }
        public int peek()
        {
            if(start==null)
                return -1;
            return start.val;
        }
        public boolean isEmpty()
        {
            return (size==0);
        }
    }

    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();

        // Push elements into queue
        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Front element (peek): " + q.peek()); // 10

        System.out.println("Removed element (pop): " + q.pop()); // 10
        System.out.println("Front element after pop: " + q.peek()); // 20

        q.push(40);
        q.push(50);

        System.out.println("Removed element: " + q.pop()); // 20
        System.out.println("Removed element: " + q.pop()); // 30
        System.out.println("Front element: " + q.peek()); // 40

        // Check if empty
        while (!q.isEmpty()) {
            System.out.println("Popped: " + q.pop());
        }

        System.out.println("Is queue empty? " + q.isEmpty()); // true
    }
}
