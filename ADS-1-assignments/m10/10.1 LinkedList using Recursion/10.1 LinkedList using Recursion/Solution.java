import java.util.Scanner;
//import java.util.Arrays;

/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution() {

    }
    /**
     * reads the input and calls the mnethods.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList li = new LinkedList();
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String[] arr1 = str1.split(" ");
            switch (arr1[0]) {
            case "insertAt":
        li.insertAt(Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]));
                break;
            case "reverse":
                try {
                    li.reverse();
                    //li.print();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
            default:
                break;
            }
        }
        // li.insertAt(0, 6);
        // li.insertAt(0, 5);
        // li.insertAt(1, 7);
        // li.insertAt(2, 8);
        // li.insertAt(3, 9);
        // li.insertAt(-1, 9);
        // li.insertAt(7, 9);
        // li.reverse();
        //li.insertAt(0,5);
        //li.insertAt(0,7);
        //li.insertAt(1,9);
        //li.reverse();
        // li.insertAt(7,8);
        //li.insertAt(2,17);
        //li.insertAt(2,27);
        // li.insertAt(0,71);
        // li.insertAt(0,75);
        // //li.insertAt(0,75);
        // li.insertAt(5,66);

    }
}
