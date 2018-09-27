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
     * @param      args  The arguments of string type
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int sizeoffirstarray = scan.nextInt();
        int sizeofsecondarray = scan.nextInt();
        int[] firstarray = new int[sizeoffirstarray];
        int[] secondarray =  new int[sizeofsecondarray];
        scan.nextLine();
        String[] data1 = scan.nextLine().split(",");
        String[] data2 = scan.nextLine().split(",");
        for (int i = 0; i < sizeoffirstarray; i++) {
            firstarray[i] = Integer.parseInt(data1[i].trim());
        }

        for (int i = 0; i < data2.length; i++) {
            secondarray[i] = Integer.parseInt(data2[i].trim());
        }
        sort(firstarray, secondarray);
    }
    /**
     * { It will add the sorted arrays in to single array sorted }.
     *
     * @param      arr1  The arr1 is sorted array1
     * @param      arr2  The arr2 is sorted array2
     */
    public static void sort(final int[] arr1, final int[] arr2) {
        int m = 0, n = 0, i = 0;
        int size =  arr1.length + arr2.length;
        int[] finalarray = new int[size];
        while (m < arr1.length && n < arr2.length) {
            // System.out.println(m+" "+n);
            if (arr1[m] < arr2[n]) {
                finalarray[i++] = arr1[m];
                m = m + 1;
            } else if (arr1[m] > arr2[n]) {
                finalarray[i++] = arr2[n];
                n = n + 1;
            }
        }
        if (arr1.length > arr2.length) {
            while (i < size) {
                finalarray[i++] = arr1[m++];
            }

        }
        if (arr2.length > arr1.length) {
            while (i < size) {
                finalarray[i++] = arr2[n++];
            }

        }
        System.out.println(Arrays.toString(finalarray).
            replace(" ", "").replace("[", "").replace("]", ""));
    }
}


