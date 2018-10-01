/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
final class Solution {
    /**.
     * { function_description }
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * { var_description }
         */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < num; i++) {
            Operations op = new Operations();
            String jose = scan.nextLine();
            String[] jos = jose.split(" ");
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
