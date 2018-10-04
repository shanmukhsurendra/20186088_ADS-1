import java.util.*;
class Solution {
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
				try{
				li.reverse();
				//li.print();
			}
				catch (Exception e) {
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
		// li.insertAt(0,5);
		// li.insertAt(0,7);
		// li.insertAt(1,9);
		// 	li.reverse();
		// li.insertAt(7,8);
		// li.insertAt(2,17);
		// li.insertAt(2,27);
		// li.insertAt(0,71);
		// li.insertAt(0,75);
		// //li.insertAt(0,75);
		// li.insertAt(5,66);

	}
}
class LinkedList<E> {
	private class Node {
		E data;
		Node next;
	}
	Node head, tail;
	Node thead = head;
	int count = 0;
	int size = 0;
	public void addAtHead(E data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		if (head == null) tail = node;
		head = node;
		size++;
		thead = head;
		print();
	}
	public void insertAt(int index, E data) {
		try {
			if (index >= 0 && index <= size ) {
				if (index == 0) {
					addAtHead(data);
					//thead = head;
					return;
				}
				if (count == index-1) {
					Node node = new Node();
					node.data = data;
					node.next = thead.next;
					thead.next = node;
					thead = head;
					size++;
					print();
					// }
				} else {
					count++;
					//System.out.println(count);
					//System.out.println("================");
					if (thead.next != null) {
						//System.out.println("================");
						//System.out.println(thead.next);
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
	public void print() {
		Node thead = head;
		while (thead != null && thead.next != null) {
			System.out.print(thead.data + ", ");
			thead = thead.next;
		}
		System.out.println(thead.data);
		//System.out.println(size);
	}
	// public void reverse() {

	// }
	void reverse() {
		head = reverseHelper(head);
		thead = head;
		print();
	}

	Node reverseHelper(Node head) {
		if (head == null || head.next == null) return head;
		Node ahead = reverseHelper(head.next);
		head.next.next = head;
		head.next = null;
		return ahead;
	}
}