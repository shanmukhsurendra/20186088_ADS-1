import java.util.*;
class Steque {
	/**
	 * Class for node.
	 */
    private class Node {
        int data;
        Node next;
    }
    Node head, next, tail;
    int size = 0;
    /**
     * push method is used to push the elements into linked list from the 
     * left side we can consider it as the top of the stack.
     * Worst case: O(1)
     * Best case: O(1)
     * Average case: O(1)
     *
     * @param      data  The data
     */
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
    /**
     * enqueue is used to push the elements into linked list from the back 
     * end.
     * Worst case: O(1)
     * Best case: O(1)
     * Average case: O(1)
     *
     * @param      data  The data
     */
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
    /**
     * it removes the element from the linked list and prints the remaining
     * elements.
     * Worst case: O(1)
     * Best case: O(1)
     * Average case: O(1)
     */
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
    /**
     * prints the elements in the linked list considering headf as the starting psotion.
     * Worst case: O(N)
     * Best case: O(N)
     * Average case: O(N)
     */
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