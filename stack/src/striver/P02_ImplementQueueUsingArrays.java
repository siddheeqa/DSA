package striver;
public class P02_ImplementQueueUsingArrays {
    static class ArrayQueue
    {
        //Array to store queue elements
        int[] arr;
        //Indices for start and end of the queue
        int start,end;
        int currSize,maxSize;
        //constructor
        public ArrayQueue()
        {
            maxSize=10;
            arr=new int[maxSize];
            start=-1;
            end=-1;
            currSize=0;
        }
        //method to push an element into the queue
        public void push(int x)
        {
            //check if the queue is full
            if(currSize==maxSize)
            {
                System.out.println("Queue is full\nExiting...");
                System.exit(1);
            }
            if(end==-1)
            {
                start=0;
                end=0;
            }
            else
            {
                //circular increment of end
                end=(end+1)%maxSize;
            }
            arr[end]=x;
            currSize++;
        }
        public int pop()
        {
            //check if queue is empty
            if(start==-1)
            {
                System.out.println("Queue Empty\nExiting...");
                System.exit(1);
            }
            int popped=arr[start];
            //if queue has only one element, reset start and end
            if(currSize==1)
            {
                start=-1;
                end=-1;
            }
            else
            {
                //circular increment of start
                start=(start+1)%maxSize;
            }
            currSize--;
            return popped;
        }
        // Method to get the front element of the queue
        public int peek() {
            // Check if the queue is empty
            if (start == -1) {
                System.out.println("Queue is Empty");
                System.exit(1);
            }
            return arr[start];
        }
        // Method to determine whether the queue is empty
        public boolean isEmpty() {
            return (currSize == 0);
        }
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();

        // Push elements into the queue
        q.push(10);
        q.push(20);
        q.push(30);

        // Print the front element
        System.out.println("Front element: " + q.peek()); // 10

        // Pop one element
        System.out.println("Popped: " + q.pop()); // 10

        // Print the new front
        System.out.println("New front: " + q.peek()); // 20

        // Check if queue is empty
        System.out.println("Is queue empty? " + q.isEmpty()); // false

        // Push more elements
        q.push(40);
        q.push(50);

        // Pop remaining elements
        System.out.println("Popped: " + q.pop()); // 20
        System.out.println("Popped: " + q.pop()); // 30
        System.out.println("Popped: " + q.pop()); // 40
        System.out.println("Popped: " + q.pop()); // 50

        // Now the queue should be empty
        System.out.println("Is queue empty after popping all? " + q.isEmpty()); // true

        // Try popping from empty queue (will exit program)
        // q.pop();
    }
}
