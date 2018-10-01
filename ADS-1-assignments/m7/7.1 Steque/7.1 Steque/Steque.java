import java.util.*;
class Steque {
    private class Node {
        int data;
        Node next;
    }
    Node head, next, tail;
    int size = 0;
    public void push(int data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        if (head == null) {
            tail = node;
        }
        head = node;
        //print();
        size++;
    }

    public void enqueue(int data) {
        if (head == null || tail == null) {
            push(data);
        } else {
            Node node = new Node();
            node.data = data;
            tail.next = node;
            tail = node;
            //print();
        }
        size++;
    }
    public void pop() {
        if (head == null) {
            //System.out.println("Steque is empty.");
        } else {
            try {
                head = head.next;
                //print();
            } catch (Exception E) {
                //System.out.println("Steque is empty.");
            }
        }
        size--;
    }
    public void print() {

        Node thead = head;
        try{
        while (thead != null && thead.next != null) {
            System.out.print(thead.data + ", ");
            thead = thead.next;
        }
        System.out.println(thead.data);
} catch(Exception e) {
		System.out.println("Steque is empty.");
    }
}
}