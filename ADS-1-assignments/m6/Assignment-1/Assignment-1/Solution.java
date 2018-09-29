import java.util.Scanner;
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
        LinkedList list = new LinkedList();
        String[] numbers = number.split("");
        for(int i =0;i<numbers.length;i++) {
            list.push(Integer.parseInt(String.valueOf(numbers[i])));
        }
        return list;
    }

    public static String digitsToNumber(LinkedList list) {
        String number = list.print();
        return number;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return list1;
    }
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
	Node head;
	public  class Node {
		int data;
		Node next;
		Node(int data) {
			this.data=data;

		}
	}
	public  void push(int data) {
		Node node = new Node(data);
		node.next=null;

		if(head==null) {
			head = node;
		} else {
			Node thead = head;
			while(thead.next!=null) {
				thead=thead.next;
			}
			thead.next=node;
		}
	}
	public void pop(int i) {
		Node thead = head;
		while(thead.next.next!=null) {
			thead = thead.next;
		}
		thead.next = null;
	}
	public void add(){

	}
	public String print() {
			Node thead = head;
			String content = "";
			while(thead !=null) {
				content+=thead.data;
				thead=thead.next;
			}
			return content;
	}
}