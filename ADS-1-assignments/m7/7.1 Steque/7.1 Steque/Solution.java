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
		if (head == null) {
			tail = node;
		}
		head = node;
		print();
		size++;
	}

	public void enqueue(int data) {
		//Node node = new Node();
		if (head == null || tail == null) {
			push(data);
			//System.out.println("------------");
			//return;
		} else {
			//System.out.println("---- i am here");
			Node node = new Node();
			node.data = data;
			tail.next = node;
			tail = node;
			print();
		}
		size++;
	}
	public void pop() {
		if (head == null) {
			//System.out.println("Steque is empty");
			System.out.println("Steque is empty.");
		} else {
			try {
				head = head.next;
				print();
			} catch (Exception E) {
				System.out.println("Steque is empty.");
			}
		}
		size--;
		// 	if(head == null){
		// 		System.out.println("Stack is empty.");
		// 	}else{
		// 	int data = head.data;
		// 	head = head.next;
		// 	print();
		// }
	}
	public void print() {

		Node thead = head;
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
		sc.nextLine();
		int i = 0;
		while (i < numb) {
			Steque li = new Steque();
				while (sc.hasNext()) {
					String str1 = sc.nextLine();
					String[] arr1 = str1.split(" ");
					switch (arr1[0]) {
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
						System.out.println(arr1[0]);
						break;
					}
				//System.out.println();
			}			//System.out.println();
			i++;
		}
		//System.out.println();

	}
}