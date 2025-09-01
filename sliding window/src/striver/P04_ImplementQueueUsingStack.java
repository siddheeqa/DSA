package striver;

import java.util.Stack;

public class P04_ImplementQueueUsingStack {
    //Using Two Stacks Where Push Operation is O(1)
    //Time Complexity: O(1)
    //Space Complexity: O(2N)
    static class StackQueue2
    {
        private Stack<Integer> input, output;
        public StackQueue2() {
            input = new Stack<>();
            output = new Stack<>();
        }
        public void push(int x) {
            input.push(x);
        }
        // Removes the element from in front of queue and returns that element
        public int pop() {
            // Shift input to output if output is empty
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }

            // If queue is still empty, return -1 (or throw an error if preferred)
            if (output.isEmpty()) {
                System.out.println("Queue is empty, cannot pop.");
                return -1;
            }

            return output.pop();
        }

        // Get the front element
        public int peek() {
            // Shift input to output if output is empty
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }

            // If queue is still empty, return -1 (or throw an error if preferred)
            if (output.isEmpty()) {
                System.out.println("Queue is empty, cannot peek.");
                return -1;
            }

            return output.peek();
        }

        // Returns true if the queue is empty, false otherwise
        public boolean isEmpty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
    //Using two Stacks where push operation is O(N)
    //Time Complexity: O(N)
    //Space Complexity: O(2N)
    static class StackQueue{
    private Stack<Integer> stack1,stack2;
    //constructor
        public StackQueue()
        {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }
        public void push(int x)
        {
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            //insert the current element
            stack1.push(x);
            while(!stack2.isEmpty())
            {
                stack1.push(stack2.pop());
            }
        }
        public int pop()
        {
            if(stack1.isEmpty())
            {
                System.out.println("Stack is empty");
                return -1;
            }
            int topElement = stack1.pop();
            return topElement;
        }
        public int peek()
        {
            if(stack1.isEmpty())
            {
                System.out.println("Stack is empty");
                return -1;
            }
            return stack1.peek();
        }
        public boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

    public static void main(String[] args) {
        StackQueue2 stack = new StackQueue2();

        System.out.println("Pushing elements: 10, 20, 30");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // should print 30
        System.out.println("Pop element: " + stack.pop()); // should remove 30
        System.out.println("Top element after pop: " + stack.peek()); // should print 20

        System.out.println("Is stack empty? " + stack.peek());

        stack.pop(); // removes 20
        stack.pop(); // removes 10

        System.out.println("Is stack empty after popping all? " + stack.isEmpty());
    }
}
