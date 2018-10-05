import java.util.*;
class Solution {
    /**
     * reads the input and calls the mnethods. 
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList li = new LinkedList();
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String[] arr1 = str1.split(" ");
            switch (arr1[0]) {
            case "insertAt":
        li.insertAt(Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]));
                break;
            case "reverse":
                try {
                    li.reverse();
                    //li.print();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
            default:
                break;
            }
        }
        // li.insertAt(0, 6);
        // li.insertAt(0, 5);
        // li.insertAt(1, 7);
        // li.insertAt(2, 8);
        // li.insertAt(3, 9);
        // li.insertAt(-1, 9);
        // li.insertAt(7, 9);
        // li.reverse();
        //li.insertAt(0,5);
        //li.insertAt(0,7);
        //li.insertAt(1,9);
        //li.reverse();
        // li.insertAt(7,8);
        //li.insertAt(2,17);
        //li.insertAt(2,27);
        // li.insertAt(0,71);
        // li.insertAt(0,75);
        // //li.insertAt(0,75);
        // li.insertAt(5,66);

    }
}
/**
 * List of linkeds.
 *
 * @param      <E>   generic variable.
 */
class LinkedList<E> {
    /**
     * Class for node.
     */
    private class Node {
        E data;
        Node next;
    }
    Node head, tail;
    Node thead = head;
    int count = 0;
    int size = 0;
    /**
     * Adds an at head.
     *
     * @param      data  The data
     */
    public void addAtHead(E data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        if (head == null) tail = node;
        head = node;
        size++;
        print();
        thead = head;
    }
    /**
     * inserts the element at the required position
     *
     * @param      index  The index
     * @param      data   The data
     */
    public void insertAt(int index, E data) {
        try {
            if (index >= 0 && index <= size ) {
                if (index == 0) {
                    addAtHead(data);
                    //thead = head;
                    return;
                }
                if (count == index - 1) {
                    //System.out.println(count);
                    //System.out.println(thead.data);
                    Node node = new Node();
                    node.data = data;
                    node.next = thead.next;
                    thead.next = node;
                    size++;
                    print();
                    thead = head;
                    // }
                } else {
                    count++;
                    //System.out.println(count);
                    //System.out.println("================");
                    //System.out.println("value"+thead.next.data);
                    if (thead.next != null) {
                        //System.out.println("================");
                        //System.out.println("value"+thead.next.data);
                        thead = thead.next;
                    }
                    insertAt(index, data);
                }
            } else {
                throw new IndexOutOfBoundsException();
                //thead = head;
            }
        } catch (Exception e) {
            System.out.println("Can't insert at this position.");
            thead = head;
        }
    }
    /**
     * prints the linked list.
     */
    public void print() {
        Node thead = head;
        while (thead != null && thead.next != null) {
            System.out.print(thead.data + ", ");
            thead = thead.next;
        }
        System.out.println(thead.data);
        count = 0;
        //System.out.println(size);
    }
    // public void reverse() {

    // }
    
    /**
     * reverse the given linked list.
     */
    void reverse() {
        head = reverseHelper(head);
        thead = head;
        print();
    }
/**
 * it helps the reveerse function to reverse the linked list.
 *
 * @param      head  The head
 *
 * @return     returns the head.
 */
    Node reverseHelper(Node head) {
        if (head == null || head.next == null) {
         return head;
            }
        Node ahead = reverseHelper(head.next);
        head.next.next = head;
        head.next = null;
        return ahead;
    }
}