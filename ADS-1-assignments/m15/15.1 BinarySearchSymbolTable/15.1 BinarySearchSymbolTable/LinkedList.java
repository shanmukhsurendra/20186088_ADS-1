public class LinkedList<E>  {
	private class Node {
		E data;
		E value;
		Node next;
	}
		int size = 0;
	Node head, tail;
	public void addAtHead(E data, E val) {
		Node thead = head;
		int count = 0;
		while(thead != null) {
			if(thead.data.equals(data)){
				//System.out.println("psycho is here");
				thead.value = val;
				count = count + 1;
				return;
			}
			thead = thead.next;
		}
		if(count == 0 || thead == null){
		Node node = new Node();
		node.data = data;
		node.value = val;
		node.next = head;
		if (head == null) tail = node;
		head = node;
		print();
		size++;
	}
	}
	public void sort() {
		Node thead = head;
		while(thead.next != null){

		}
	}
	// public void floor(E key){
	// 	Node thead = head;
	// 	if( thead.data.equals(key){
	// 		System.out.println(key);
	// 		return;
	// 	}
	// 	while(thead.next!= null){
	// 		E temp;
	// 		int count = 0;
	// 		if(thead.data < key) {
	// 			temp =
	// 		} 
	// 	}
	// }

// 	public void addAtTail(E data) {
// 		if (tail == null) {
// 			addAtHead(data);
// 			return;
// 		}
// 		Node node = new Node();
// 		node.data = data;
// 		tail.next = node;
// 		tail = tail.next;
// 	}

// 	public void deleteAtHead() {
// 		head = head.next;
// 	}

// 	public E popAtHead() {
// 		E data = head.data;
// 		head = head.next;
// 		return data;
// 	}

// 	public void deleteAtTail() {
// 		Node thead = head;
// 		while (thead.next != tail)
// 			thead = thead.next;
// 		thead.next = null;
// 		tail = thead;
// 	}

// 	public E popAtTail() {
// 		E data = tail.data;
// 		Node thead = head;
// 		while (thead.next != tail)
// 			thead = thead.next;
// 		thead.next = null;
// 		tail = thead;
// 		return data;
// 	}

// 	public void insertAfter(int index, E data) {
// 		Node thead = head;
// 		for (int i = 0; i < index; i++)
// 			thead = thead.next;
// 		Node node = new Node();
// 		node.data = data;
// 		node.next = thead.next;
// 		thead.next = node;
// 	}

// 	public void removeAfter(int index) {
// 		Node thead = head;
// 		for (int i = 0; i < index; i++)
// 			thead = thead.next;
// 		thead.next = thead.next.next;
// 	}

	public void print() {
		Node thead = head;
		while(thead != null) {
			System.out.println(thead.data+" "+ thead.value);
			thead = thead.next;
		}
	}
// 		// while (thead != null && thead.next != null) {
// 		// 	System.out.print(thead.data + " --> ");
// 		// 	thead = thead.next
// 		// }
// 		// System.out.println(thead.data);
// 	}

// // 	public Iterator<E> iterator() {
// // 		return new MyIterator<E>(head);
// // 	}

// // 	private class MyIterator<E> implements Iterator<E> {
// // 		Node<E> current;

// // 		public MyIterator(Node<E> first) {
// // 			current = first;
// // 		}

// // 		public boolean hasNext() {
// // 			return current !=  null;
// // 		}

// // 		public void remove() {

// // 		}

// // 		public E next() {
// // 			E data = current.data;
// // 			current = current.next;
// // 			return data;
// // 		}
// // 	}



// 	public static void main(String[] args) {
// 		LinkedList<Integer> l = new LinkedList<>();
// 		l.insertAfter(0,5);
// 		l.popAtHead();

// 	}
// 		// l.addAtHead(2);
// 		// l.addAtHead(3);
// 		// l.addAtTail(65);

// // 		// l.print();
// // 		// System.out.println("--------");
// // 		// // System.out.println(l.popAtHead());
// // 		// System.out.println("--------");

// // 		// l.print();
// // 		// System.out.println("--------");

// // 		// // System.out.println(l.popAtTail());
// // 		// System.out.println("--------");
// // 		// l.print();
// // 		// System.out.println("--------");
// // 		// // System.out.println(l.popAtTail());
// // 		// System.out.println("--------");
// // 		// l.print();
// // 		// System.out.println("---------");
// // 		// l.insertAfter(0, 5);
// // 		// l.print();
// // 		// l.insertAfter(2, 6);
// // 		// l.print();

// // 		// Integer data;

// // 		System.out.println("1.");
// // 		for (Iterator<Integer> c = l.iterator(); c.hasNext(); System.out.println(c.next()));

// // 		System.out.println("2.");
// // 		for (Integer e : l)
// // 			System.out.println(e);

// // 		System.out.println("3.");
// // 		l.forEach(e -> System.out.println(e));


// // 		System.out.println("4.");
// // 		Iterator<Integer> c = l.iterator();
// // 		while(c.hasNext())
// // 			System.out.println(c.next());

// // 	}
}