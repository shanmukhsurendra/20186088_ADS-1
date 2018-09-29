import java.util.Scanner;
class AddLargeNumbers {
	//LinkedList li = new LinkedList();
	// private class Node {
	// 	int data;
	// 	Node next;
	// }
	// Node head, tail;
//    public void addAtHead(int data) {
	// 	Node node = new Node();
	// 	node.data = data;
	// 	node.next = head;
	// 	if (head == null) tail = node;
	// 	head = node;
	// }
	public static LinkedList numberToDigits(String number) {
		// for (int i = 0, n = number.length(); i < n; i++) {
		// 	char c = number.charAt(i);
		// 	int a = Integer.parseInt(c);
		// 	li.addAtHEad(Integer.parseInt(a));
		// }
		// char[] chars = number.toCharArray();
		// for (int i = 0, n = chars.length; i < n; i++) {
		// 	int c = Integer.parseInt(chars[i]);
		// }
		// return li.print();
		// LinkedList l = new LinkedList();
		LinkedList li = new LinkedList();
		String[] arra = number.split("");
		for (int i = 0; i < arra.length; i++) {
			li.addAtHead(arra[i]);
		}
		//l.printList();
		return li;
	}

	public static String digitsToNumber(LinkedList list) {
		 String str = "";
        while(!list.isEmpty()) {
            str += list.popAtHead();
        }
        return str;
    }
	

	public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
		return new LinkedList();
	}
	//   public void print() {
	// Node thead = head;
	// while(thead != null) {
	// 	System.out.println(thead.data);
	// 	thead = thead.next;
	// }

}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String p = sc.nextLine();
		String q = sc.nextLine();
		switch (input) {
		case "numberToDigits":
			LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
			LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
			System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
			System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
			break;

		case "addLargeNumbers":
			pDigits = AddLargeNumbers.numberToDigits(p);
			qDigits = AddLargeNumbers.numberToDigits(q);
			LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			System.out.println(AddLargeNumbers.digitsToNumber(result));
			break;
		}
	}

}
class LinkedList {
	private class Node {
		String data;
		Node next;
	}
		int size = 0;
	Node head, tail;
	public void addAtHead(String data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		if (head == null) tail = node;
		head = node;
		size++;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void addAtTail(String data) {
		if (tail == null) {
			addAtHead(data);
			return;
		}
		Node node = new Node();
		node.data = data;
		tail.next = node;
		tail = tail.next;
		size++;
	}

	public void deleteAtHead() {
		head = head.next;
		size--;
	}

	public String popAtHead() {
		String data = head.data;
		head = head.next;
		size--;
		return data;
	}

	public void deleteAtTail() {
		Node thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
		size--;
	}

	public String popAtTail() {
		String data = tail.data;
		Node thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
		size--;
		return data;
	}

	public void insertAfter(int index, String data) {
		Node thead = head;
		for (int i = 0; i < index; i++)
			thead = thead.next;
		Node node = new Node();
		node.data = data;
		node.next = thead.next;
		thead.next = node;
		size++;
	}

	public void removeAfter(int index) {
		Node thead = head;
		for (int i = 0; i < index; i++)
			thead = thead.next;
		thead.next = thead.next.next;
		size--;
	}

	public void print() {
		Node thead = head;
		while (thead != null) {
			System.out.println(thead.data);
			thead = thead.next;
		}
	}
}