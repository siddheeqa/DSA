package striver;

import java.util.Arrays;
public class P01_ImplementStackUsingArrays {
    static class ArrayStack
    {
        //Array to hold elements
        private int[] stackArray;
        //Maximum capacity
        private int capacity;
        //  Index of top element
        private int topIndex;

        //constructor
        public ArrayStack(int size)
        {
            capacity=size;
            stackArray=new int[capacity];
            //Initialize stack as empty
            topIndex=-1;
        }
        //Default size for the array stack
        public ArrayStack()
        {
            this(1000);
        }
        public void push(int x)
        {
            if(topIndex>=capacity-1)
            {
                System.out.println("Stack Overflow");
                return;
            }
            stackArray[++topIndex]=x;
        }
        //Removes and returns top element
        public int pop()
        {
            if(isEmpty())
            {
                System.out.println("Stack is empty");
                return -1;
            }
            return stackArray[topIndex--];
        }
        //Return top element
        public int top()
        {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stackArray[topIndex];
        }
        public boolean isEmpty()
        {
            return topIndex==-1;
        }
    }
    public static void main(String[] args) {
        // Create a stack of size 5
        ArrayStack stack = new ArrayStack(5);

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Print the top element
        System.out.println("Top element: " + stack.top()); // 30

        // Pop one element
        System.out.println("Popped: " + stack.pop()); // 30

        // Print the new top
        System.out.println("New top: " + stack.top()); // 20

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        // Pop remaining elements
        stack.pop(); // removes 20
        stack.pop(); // removes 10

        // Now stack should be empty
        System.out.println("Is stack empty after popping all? " + stack.isEmpty()); // true

        // Try popping from empty stack
        stack.pop(); // Should p
    }
}
