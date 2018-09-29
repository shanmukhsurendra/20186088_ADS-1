import java.util.*;
class LinkedList {
	Node head;
	int size = 0;
	public  class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;

		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public  void push(int data) {
		Node node = new Node(data);
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			Node thead = head;
			while (thead.next != null) {
				thead = thead.next;
			}
			thead.next = node;
		}
		size++;
	}
	public void pop(int i) {
		Node thead = head;
		while (thead.next.next != null) {
			thead = thead.next;
		}
		thead.next = null;
		size--;
	}
	public String print() {
		Node thead = head;
		String content = "";
		while (thead != null) {
			content += thead.data;
			thead = thead.next;
		}
		return content;
	}
}