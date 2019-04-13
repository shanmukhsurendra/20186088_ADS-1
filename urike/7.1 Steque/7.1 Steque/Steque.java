class Steque {
	Node head;
	int size;
	class Node {
		int data;
		Node next;
		Node(int n) {
			this.data = n;
		}
	}
	Steque() {

	}
	void push(int n) {
		Node newnode = new Node(n);
		if(size == 0) {
			head = newnode;
			head.next = null;

		} else {
			newnode.next = head;
			newnode = head;

		}
		size++;
		print();
	}
	void enqueue(int n) {
		Node newnode = new Node(n);
		if(size == 0) {
			head = newnode;
			head.next = null;

		} else {
			Node thead = head;
			while (thead.next != null) {
				thead = thead.next;
			}
			thead.next = newnode;
 		}
 		size++;
 		print();
	}
	void pop() {
		Node thead = head.next;
		head = thead;
		size--;
		print();
	}
	void print() {
		if(size == 0) {
			System.out.println("Steque is empty");
		}
		Node thead = head;
		while(thead.next.next != null) {
			System.out.println(thead.data + ",");
			thead = thead.next;
		}
		System.out.println(thead.next.data);
	}
}