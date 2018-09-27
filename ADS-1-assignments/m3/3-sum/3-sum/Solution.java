import java.util.Scanner;
import java.util.Arrays;
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
     * { main method to read the input }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeofarray = scan.nextInt();
        int key;
        int[] array = new int[sizeofarray];
        for (int i = 0; i < sizeofarray; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(threesum(array));
    }
    /**
     * { To find the no of occurences of 3 sum problem }.
     *
     * @param      array  The array is of integer type
     *
     * @return     { Count is returned }
     */
    public static int threesum(final int[] array) {
        int count = 0;
        int k = 0, j = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            j = i + 1;
            k = array.length - 1;
            while (j < k) {
                if (array[i] + array[j] + array[k] == 0) {
                    count++;
                    j++;
                    k--;
                } else if (array[i] + array[j] + array[k] > 0) {
                    k--;
                } else if (array[i] + array[j] + array[k] < 0) {
                    j++;
                }
            }
        }
        return count;
    }
}