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
     * { main method to handle the input }.
     *
     * @param      args  The arguments of string array type
     */
    public static void main(final String[] args) {
        Merge m = new Merge();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] data = s.nextLine().split(",");
            m.sort(data);
            System.out.println(m.show(data));
            System.out.println();

        }
    }
}

