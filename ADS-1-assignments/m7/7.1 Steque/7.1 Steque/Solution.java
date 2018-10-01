import java.util.*;
class Steque {
	// Node head;
	// int size = 0;
	private class Node {
		int data;
		Node next;
	}
	Node head, next, tail;
	int size = 0;
	public void push(int data) {
		// Node node = new Node();
		// node.data = data;
		// node.next = head;
		// if (head == null) {
		// 	tail = node;
		// }
		// head = node;
		Node node = new Node();
		node.data = data;
		node.next = head;
		if (head == null) tail = node;
		head = node;
		print();
		size++;
	}

	public void enqueue(int data) {
		Node node = new Node();
		if (head == null) {
			push(data);
			print();
		} else {
			node.data = data;
			tail.next = node;
			node.next = null;
			tail = node;
			print();
		}
		size++;
	}
	public void pop() {
		if (head == null) {
			System.out.println("Steque is empty");
		} else {
			try {
				head = head.next;
				print();
			} catch (Exception E) {
				System.out.println("Steque is empty" );
			}
		}
		size--;
	}
	public void print() {

		Node thead = head;
		// while (thead != null) {
		// 	System.out.print(thead.data);
		// 	thead = thead.next;

		// }
		while (thead != null && thead.next != null) {
			System.out.print(thead.data + ", ");
			thead = thead.next;
		}
		System.out.println(thead.data);
	}
}
class Solution {
	public static void main(String[] args) {
		// Steque li = new Steque();
		// li.push(1);
		// li.push(2);
		// li.push(3);
		// li.push(4);
		// li.head = null;
		// li.size = 0;
		// System.out.println("-----------------");
		// li.enqueue(0);
		// //System.out.println("--------------");
		// li.enqueue(1);
		// //System.out.println("--------------");
		// li.pop();
		// li.pop();
		// li.pop();
		// li.pop();
		// li.pop();
		// li.pop();
		// li.pop();
		Scanner sc = new Scanner(System.in);
		int numb = sc.nextInt();
		int i = 0;
		while(i< numb){
			try{
			while(sc.hasNext()) {
				Steque li = new Steque();
				String str1 = sc.nextLine();
				String[] arr1 = str1.split(" ");
				switch(arr1[0]){
					case "pop":
					li.pop();
					break;
					case "push":
					li.push(Integer.parseInt(arr1[1]));
					break;
					case "enqueue":
					li.enqueue(Integer.parseInt(arr1[1]));
					break;
					default:
					break;
				}
			}
		}catch(Exception e) {
			System.out.println();
		}
		i++;
		}

	}
}