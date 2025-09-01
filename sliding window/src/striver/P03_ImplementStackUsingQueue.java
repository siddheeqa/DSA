package striver;

import java.util.LinkedList;
import java.util.Queue;
//Push operation: O(n)
//Pop operation: O(1)
//Top operation: O(1)
//IsEmpty operation: O(1)
//Space Complexity: O(k)
public class P03_ImplementStackUsingQueue {
    static class QueueStack
    {
        Queue<Integer> queue=new LinkedList<>();
        public void push(int x)
        {
            //get size
            int size=queue.size();
            queue.add(x);
            //move elements before new element to back
            for(int i=1;i<=size;i++)
                queue.add(queue.poll());
        }
        public int pop()
        {
            int element=queue.peek();
            queue.poll();
            return element;
        }
        public int top()
        {
            return queue.peek();
        }
        public boolean isEmpty()
        {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        QueueStack stack = new QueueStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());   // 30
        System.out.println("Popped: " + stack.pop());       // 30
        System.out.println("Top element after pop: " + stack.top()); // 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        stack.pop();
        stack.pop();
        System.out.println("Is stack empty now? " + stack.isEmpty()); // true
    }
}
