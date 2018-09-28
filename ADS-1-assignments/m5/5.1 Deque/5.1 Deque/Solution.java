import java.util.*;
class Node {
	int data;
	Node link;
	Node() {
		link = null;
		data = 0;
	}
	Node(int d, Node n) {
		data = d;
		link = n;
	}
	public void setLink(Node n ) {
		link = n;
	}
	void setData(int d) {
		data = d;
	}
	Node getLink() {
		return link;
	}
	int getData() {
		return data;
	}
}
class LinkedList {
	Node front, rear;
	int size;
	LinkedList() {
		front = null;
		rear = null;
		size = 0;
	}
	public void pushLeft(int val) {
		Node nptr = new Node(val, null);
		size++ ;
		if (front == null) {
			front = nptr;
			rear = front;
		} else {
			nptr.setLink(front);
			front = nptr;
		}
		printList();
	}
	public void pushRight(int val) {
		Node nptr = new Node(val, null);
		size++ ;
		if (front == null) {
			front = nptr;
			rear = front;
		} else {
			rear.setLink(nptr);
			rear = nptr;
		}
		printList();
	}
	public void printList() {
		//System.out.print("\nSingly Linked List = ");
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (front.getLink() == null) {
			System.out.println("["+front.getData()+"]" );
			return;
		}
		System.out.print("[");
		Node ptr = front;
		System.out.print(front.getData() + ", ");
		ptr = front.getLink();
		while (ptr.getLink() != null) {
			System.out.print(ptr.getData() + ", ");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData() + "]" + "\n");
	}
	public void size() {
		System.out.println(size);
	}
	void popLeft() {
		front = front.getLink();
		size--;
		printList();
	}
	void popRight() {
		Node s = front;
		Node t = front;
		while (s != rear) {
			t = s;
			s = s.getLink();
		}
		rear = t;
		rear.setLink(null);
		size --;
		printList();
	}
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int choice = scan.nextInt();
		//int k = 1;
		while (scan.hasNext()) {
			String ch = scan.nextLine();
			String[] arra = ch.split(" ");
			switch (arra[0]) {
			case "pushLeft":
				list.pushLeft(Integer.parseInt(arra[1]));
				break;
			case "pushRight":
				list.pushRight(Integer.parseInt(arra[1]));
				break;
			case "size":
				list.size();
				break;
			case "popRight":
				list.popRight();
				break;
			case "popLeft":
				list.popLeft();
				break;
			default:
				break;
			}
		}
	}
}