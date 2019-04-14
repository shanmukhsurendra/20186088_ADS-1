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
		if (size == 0) {
			head = newnode;
			head.next = null;

		} else {
			// System.out.println(head.data);
			newnode.next = head;
			
			// System.out.println(newnode.next.data);
			// System.out.println(newnode.data);
			
			head = newnode;
			// System.out.println(head.data);

		}
		size++;
		print();
	}
	void enqueue(int n) {
		Node newnode = new Node(n);
		if (size == 0) {
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
		if (size != 0) {
		Node thead = head.next;
		head = thead;
		size--;
	}
		print();
	}
	void print() {
		Node thead = head;
		try {
			while (thead != null && thead.next != null) {
				System.out.print(thead.data + ", ");
				thead = thead.next;
			}
			System.out.println(thead.data);
		} catch (Exception e) {
			System.out.println("Steque is empty.");
		}
	}
}