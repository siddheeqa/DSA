package striver;

import java.util.Stack;

public class P08_MinStack {
    //Time Complexity: O(1)
    //Space Complexity: O(2*N)
    static class MinStack2 {
        private Stack<Integer> stack;
        private int mini;

        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int value) {
            if (stack.isEmpty()) {
                mini = value;
                stack.push(value);
                return;
            }
            // If the value is greater than the minimum
            if (value > mini)
                stack.push(value);
            else {
                stack.push(2 * value - mini);
                //update the minimum
                mini = value;
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;
            int top = stack.pop();
            if (top < mini) {
                mini = 2 * mini - top;
            }
        }

        public int top() {
            if (stack.isEmpty()) return -1;
            int top = stack.peek();
            if (mini < top) return top;
            return mini;
        }

        public int getMin() {
            return mini;
        }
    }

    static class MinStack {
        //initialize a stack
        private Stack<int[]> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int value) {
            if (stack.isEmpty()) {
                stack.push(new int[]{value, value});
                return;
            }
            int min = Math.min(getMin(), value);
            stack.push(new int[]{value, min});
        }

        public void pop() {
            if (stack.isEmpty())
                return;
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty())
                return -1;
            return stack.peek()[0];
        }

        public int getMin() {
            if (stack.isEmpty())
                return -1;
            return stack.peek()[1];
        }
    }

    public static void main(String[] args) {
        MinStack2 s = new MinStack2();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.print(s.getMin() + " ");
        s.pop();
        System.out.print(s.top() + " ");
        s.pop();
        System.out.print(s.getMin());
    }
}

