import java.util.Scanner;
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * constructor for solution class.
     */
    Solution() {
        /**.
         * empty constructor.
         */
    }
    /**.
     * reads the input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < number; i++) {
            Operations op = new Operations();
            String str1 = scan.nextLine();
            String[] jos = str1.split(" ");
            int k = Integer.parseInt(jos[0]);
            int m = Integer.parseInt(jos[1]);
            for (int j = 0; j < k; j++) {
                op.insertAtTail(j);
            }
            int[] josephus = op.josephus(m, k);
            for (int p = 0; p < josephus.length - 1; p++) {
                System.out.print(josephus[p] + " ");
            }
            System.out.println(josephus[josephus.length - 1]);
        }
    }
}