import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * reads the input from the file and insert the elements into array
	 * and checks the number of possibilities 3sum from the elements 
	 * in array.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		/**
		 * we initialise the array here.
		 */
		int arr[];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		arr = new int[n];
		while (i < n) {
			arr[i] = sc.nextInt();
			i++;
		}
		Arrays.sort(arr);
		int count = 0;
		for (int k = 0; k < arr.length; k++) {
			for (int j = arr.length - 1; j > k + 1; j--) {
				if ((arr[k] + arr[k + 1] + arr[j]) == 0) {
					count += 1;
				}
			}
		}
		System.out.println(count);
	}
}