import java.util.Scanner;
/**.
 *  class for Solution to handle the input
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    }
    /**.
     * { Main method to handle the input }
     *
     * @param      args  The arguments are of string array type
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        QuickSort qs = new QuickSort();
        int testcases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcases; i++) {
            int cutOff = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                qs.sort(tokens, cutOff);
                System.out.println(qs.toString(tokens));
            }
        }
    }
}
/**
 * Class for QuickSort.
 */
class QuickSort {

    /**.
     * Constructs the object.
     */
    QuickSort() { }
    /**
     * Class for insertion sort.
     */
    class InsertionSort {
        /**
         * Constructs the object.
         */
        InsertionSort() { }
        /**.
         * { Sorts the array using insertion sort technique }
         *
         * @param      arr  The arguments is comparable array
         * @param      low  The arguments is integer type
         * @param      high  The arguments is integre type
         * Time complexity of this method is O(N) because nested loop used
         * in this method.
         */
        public void insertion(final Comparable[] arr, final int low,
         final int high) {
            for (int i = low; i <= high; i++) {
                for (int j = i; j > low && less(arr[j], arr[j - 1]); j--) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }
    /**.
     * { Swaps the positions of the elements }
     *
     * @param      arr  The arguments is comparable array
     * @param      j  The arguments is integer type
     * @param      min  The arguments is integer type
     */
    public void swap(final Comparable[] arr, final int j, final int min) {
        Comparable temp = arr[j];
        arr[j] = arr[min];
        arr[min] = temp;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @param      arr   The arr is of comparable array type
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] arr) {
        // System.out.println("in print");
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[arr.length - 1] + "]";
        return str;
    }
    /**.
     * { This method sorts the array using quicksort }
     *
     * @param      arr  The arguments is of comparable array type
     * @param      low  The arguments is ineteger type
     * @param      high  The arguments is integer type
     * @param      cutOff  The arguments is integer type
     * Time complexity of this method is O(NlogN)
     * because it uses recursion and Partition method until all elements
     * gets sorted
     */
    private void sort(final Comparable[] arr, final int low,
     final int high, final int cutOff) {
        InsertionSort in = new InsertionSort();
        if (high <= low + cutOff - 1) {
            in.insertion(arr, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(arr, low, high);
        System.out.println(toString(arr));
        sort(arr, low, k - 1, cutOff);
        sort(arr, k + 1, high, cutOff);
    }
    /**.
     * { This method is used to call private sort method }
     *
     * @param      array   The array is of comparable type
     * @param      cutOff  The cut off if integer type
     */
    public void sort(final Comparable[] array, final int cutOff) {
        sort(array, 0, array.length - 1, cutOff);
    }
    /**.
     * { Makes the partition for quicksort }
     *
     * @param      arr   The arr is of comparable array type
     * @param      low   The low is index of arr
     * @param      high  The high is index of arr
     *
     * @return     { returns the element that will be used as partition index }
     * Time complexity of this method is O(N) becuase it traverses all elements
     */
    public int partition(final Comparable[] arr,
     final int low, final int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) {
                if (i == high) {
                    break;
                }
            }
            while (less(arr[low], arr[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }
    /**.
     * { compares the two elements }
     *
     * @param      a     { element of comparable type array }
     * @param      b     { element of comparable type array }
     *
     * @return     { true if a is lessthan b, else false }
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
}



