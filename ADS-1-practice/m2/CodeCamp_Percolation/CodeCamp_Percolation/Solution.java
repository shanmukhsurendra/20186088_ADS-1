// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with
//    all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if
//    it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }

// (i-1)*N+j
// You can implement the above API to solve the problem
import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	//ArrayList<Integer> unionList;
	public static void main(String[] args) {
		/**
		 * here we read input and forward to required method.
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Percolation per = new Percolation(N);
		while (sc.hasNext()) {
			int inp1 = sc.nextInt();
			int inp2 = sc.nextInt();
			per.open(inp1 - 1, inp2 - 1);
		}
		System.out.println(per.percolates());
	}
}