import java.util.Arrays;
import java.util.Scanner;

class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfItems = sc.nextInt();
		int i = 0;
		while (i < 6) {
			int j = 0;
			while (j < numberOfItems) {
				String[] arra1 = sc.nextLine().split(",");
				System.out.println(arra1[1]);
				j++;
			}
			i++;
		}
	}
}
















// public class Solution {
// 	public static void main(String[] args) {
// 		Scanner scan = new Scanner(System.in);
// 		int n = Integer.parseInt(scan.nextLine());
// 		while (n > 0) {
// 			int hours = 6;
// 			while (hours > 0) {
// 				String[] line = scan.nextLine().split(",");
// 				System.out.println(line[1]);
// 				hours--;
// 			}
// 			System.out.println();
// 			n--;
// 		}
// 	}
// }
