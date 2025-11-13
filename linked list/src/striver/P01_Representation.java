package striver;

import java.util.ArrayList;

public class P01_Representation {
    static class Node{
        public int data;
        public Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
        public Node(int data, Node next)
        {
            this.data=data;
            this.next=next;
        }
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(8);
        arr.add(7);

        Node node1=new Node(arr.get(0),null);
        Node node2=new Node(arr.get(1),null);
        Node node3=new Node(arr.get(2),null);
        Node node4=new Node(arr.get(3),null);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        System.out.println(node1.data);
        System.out.println(node2.data);
        System.out.println(node3.data);
        System.out.println(node4.data);

    }
}
