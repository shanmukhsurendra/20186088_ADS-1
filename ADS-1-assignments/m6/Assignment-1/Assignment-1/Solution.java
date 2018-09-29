import java.util.Scanner;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * it contains three methods to perform actions.
     *
     * @param      number  The number
     *
     * @return     returns the resulted list.
     */

    public static LinkedList numberToDigits(String number) {
        /**
         * adds the given inputs to the linked list.
         */
        LinkedList list = new LinkedList();
        String[] numbers = number.split("");
        for (int i = 0; i < numbers.length; i++) {
            list.push(Integer.parseInt(String.valueOf(numbers[i])));
        }
        return list;
    }
    /**
     * prints the values in the linked list.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(LinkedList list) {
        String number = list.print();
        return number;
    }
/**
 * Adds large numbers.
 *
 * @param      list1  The list 1
 * @param      list2  The list 2
 *
 * @return    returns the resulted list after adding the elementrs in given
 * linked lists.
 */
    public static LinkedList addLargeNumbers(final LinkedList list1,
            final LinkedList list2) {
        String str1 = list1.print();
        String str2 = list2.print();
        int maxval = 0;
        Stack stack1 = new Stack(list1.print());
        Stack stack2 = new Stack(list2.print());
        LinkedList resultotal = new LinkedList();
        if (list1.print().length() > list2.print().length()) {
            maxval = list1.print().length();
        } else {
            maxval = list2.print().length();
        }
        Stack stack3 = new Stack(maxval);
        for (int a = 0; a < str1.length(); a++) {
            char digit = str1.charAt(a);
            stack1.push(Integer.parseInt(String.valueOf(digit)));
        }
        for (int b = 0; b < str2.length(); b++) {
            char digit1 = str2.charAt(b);
            stack2.push(Integer.parseInt(String.valueOf(digit1)));
        }
        int carry = 0;
        int val1 = 0;
        int val2 = 0;
        while (true) {
            val1 = 0;
            val2 = 0;
            if (stack1.isempty() && stack2.isempty()) break;
            if (!stack1.isempty()) { val1 = stack1.top();  stack1.pop(); }
            if (!stack2.isempty()) { val2 = stack2.top();  stack2.pop(); }
            int totavval = 0;
            //System.out.println(val2+"-----");
            //System.out.println(val1+"------");
            totavval = val1 + val2 + carry;
            //System.out.println(totalval);
            stack3.push(totavval % 10);
            if (totavval >= 10) carry = 1; else carry = 0;
        }
        if (list1.print().length() == list2.print().length()) {
            stack3.push(carry);
        }
        while (!stack3.isempty()) {
            //System.out.println("-----");
            int top = stack3.top();
            // System.out.println(to;p)
            stack3.pop();
            resultotal.push(top);
        }
        return resultotal;

    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * reads the input using scanner functions.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * creates object sc for scanner.
         */
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
