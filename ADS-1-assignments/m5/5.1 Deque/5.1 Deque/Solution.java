import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * reads the input and calls the recquired method.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice = scan.nextInt();
        //int k = 1;
        while (scan.hasNext()) {
            String ch = scan.nextLine();
            String[] arra = ch.split(" ");
            switch (arra[0]) {
            case "pushLeft":
                list.pushLeft(Integer.parseInt(arra[1]));
                break;
            case "pushRight":
                list.pushRight(Integer.parseInt(arra[1]));
                break;
            case "size":
                list.size();
                break;
            case "popRight":
                list.popRight();
                break;
            case "popLeft":
                list.popLeft();
                break;
            default:
                break;
            }
        }
    }
}


