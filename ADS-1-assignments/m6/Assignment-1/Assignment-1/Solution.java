import java.util.Scanner;
class AddLargeNumbers {

	public static LinkedList numberToDigits(String number) {
		LinkedList list = new LinkedList();
		String[] numbers = number.split("");
		for (int i = 0; i < numbers.length; i++) {
			list.push(Integer.parseInt(String.valueOf(numbers[i])));
		}
		return list;
	}

	public static String digitsToNumber(LinkedList list) {
		String number = list.print();
		return number;
	}

 public static LinkedList addLargeNumbers(final LinkedList list1,
            final LinkedList list2) {
         String number1 = list1.print();
        String number2 = list2.print();
        int maxlength = 0;
        LinkedList resultadded = new LinkedList();
        Stack stack1 = new Stack(list1.print());
        Stack stack2 = new Stack(list2.print());
        if (list1.print().length() > list2.print().length()) {
            maxlength = list1.print().length();
        } else {
            maxlength = list2.print().length();
        }
        Stack result = new Stack(maxlength);
        for (int i = 0; i < number1.length(); i++) {
            char digit = number1.charAt(i);
            stack1.push(Integer.parseInt(String.valueOf(digit)));
        }
        for (int i = 0; i < number2.length(); i++) {
            char digit1 = number2.charAt(i);
            stack2.push(Integer.parseInt(String.valueOf(digit1)));
        }
        int carry = 0, op1 = 0, op2 = 0;
        while (true) {
            op1 = 0;
            op2 = 0;
            if (stack1.isempty() && stack2.isempty()) break;
            if (!stack1.isempty()) { op1 = stack1.top();  stack1.pop(); }
            if (!stack2.isempty()) { op2 = stack2.top();  stack2.pop(); }
            int opTotal = 0;
            opTotal = op1 + op2 + carry;
            // System.out.println(opTotal%10);
            result.push(opTotal % 10);
            if (opTotal >= 10) carry = 1; else carry = 0;
        } 
        if (list1.print().length() == list2.print().length()) {
            result.push(carry);
        }
        while (!result.isempty()) {
            int top = result.top();
            // System.out.println(top);
            result.pop();
            resultadded.push(top);
        }
        return resultadded;

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
class Stack {
	LinkedList list = new LinkedList();
	int[] number;
	int size;
	Stack(String number1) {
		number = new int[number1.length()];
		size = 0;
	}
	Stack(int len) {
		number = new int[len+1];
		size = 0;
	}
	public void push(int digit) {
		number[size++] = digit;
	}
	public int top() {
		return number[size-1];
	}
	public void pop() {
		size--;
	}
	public boolean isempty() {
		return size == 0;
	}

}