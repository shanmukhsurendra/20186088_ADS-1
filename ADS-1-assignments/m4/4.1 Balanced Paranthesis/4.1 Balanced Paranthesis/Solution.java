 import java.util.Scanner;
/**
 * { Solution class to read the input }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { this is main method  }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);

        int nooflines = scan.nextInt();
        for (int i = 0; i < nooflines; i++) {

            String line = scan.next();
            Stack paren = new Stack(line);
            System.out.println(paren.check());
        }
    }

}
/**
 * Stack class starts here.
 */
class Stack {
    /**
     * { data is of string type }.
     */
    private String data;
    /**
     * { braces of character array }.
     */
    private char[] braces;
    /**
     * { size of braces array }.
     */
    private int size;
    /**
     * Constructs the object and initialise variables.
     *
     * @param      input  The input
     */
    Stack(final String input) {
        data =  input;
        braces = new char[data.length()];
        size = 0;
    }
    /**
     * { THis method checks the given string and returns the Yes or NO }.
     *
     * @return     { String value yes or no }
     */
    public String check() {
        for (int i = 0; i < data.length(); i++) {
            char compare = data.charAt(i);
            if (compare == '(' || compare == '{' || compare == '[') {
                push(compare);
            }
            if (size != 0) {
                if (compare == ')') {
                    if (braces[size - 1] == '(') {
                        pop(compare);
                    }
                } else if (compare == '}') {
                    if (braces[size - 1] == '{') {
                        pop(compare);
                    }
                } else if (compare == ']') {
                    if (braces[size - 1] == '[') {
                        pop(compare);
                    }
                }
            }
        }
        if (size == 0) {
            return "YES";
        }
        return "NO";
    }
    /**
     * { pushes the variable on to the stack }.
     *
     * @param      in    { individual character }
     */
    public void push(final char in) {
        braces[size++] = in;
    }
    /**
     * Deletes the element from top of the stack.
     *
     * @param      in    { indivdual character }
     */
    public void pop(final char in) {
        if (size != 0) {
            size--;
        }

    }

}