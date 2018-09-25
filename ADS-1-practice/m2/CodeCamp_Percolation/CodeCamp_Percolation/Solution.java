// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }

// (i-1)*N+j
// You can implement the above API to solve the problem
import java.util.*;
import java.io.*;
import java.lang.*;
class Percolation {
	int count;
	int[][] mainArra;
	int size;
	int top = 0;
	UF uf;
	public Percolation(int n) {
		mainArra = new int[n][n];
		size = n;
		uf = new UF(n * n + 2);
		//System.out.println(Arrays.deepToString(mainArra));
	}
	public int getIndex(int row, int column) {
		return (row) * size + column;
	}
	public boolean isOpen(int row, int column) {
		/*int temp = mainArra[row][column];
		System.out.println(temp);*/
		if (mainArra[row][column] == 1) {
			return true;
		}
		return false;
	}
	public void open(int row, int column) {
		mainArra[row][column] = 1;
		count += 1;
		/*if (isOpen(row, column - 1)) {
			union(row, column, row, column - 1)
		} else if (isOpen(row, column + 1)) {
			union(row, column, row, column - 1)
		}*/
		if(row == 0){
			uf.union(top,getIndex(row, column - 1));
		}
		if(column == size){
			uf.union(getIndex(row, column - 1), size);
		}
		if (column != 0) {
			if (isOpen(row, column - 1)) {
				uf.union(getIndex(row, column - 1), getIndex(row, column));
			}
		}
		if (column != size) {
			if (isOpen(row, column + 1)) {
				uf.union(getIndex(row, column), getIndex(row, column + 1));
			}
		}
		if (row != 1) {
			if (isOpen(row - 1, column)) {
				uf.union(getIndex(row - 1, column), getIndex(row, column));
			}
		}
		if (row != size) {
			if (isOpen(row + 1, column)) {
				uf.union(getIndex(row, column), getIndex(row + 1, column));
			}
		}
	}
	public int numberOfOpenSites() {
		return count;
	}
	public boolean isFull(int row, int column) {
		return true;
	}
	public boolean percolates(){
		return uf.connected(top,size);

	}
}
class Solution {
	//ArrayList<Integer> unionList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Percolation per = new Percolation(N);
		while (sc.hasNext()) {
			int inp1 = sc.nextInt();
			int inp2 = sc.nextInt();
			if (!per.isOpen(inp1 - 1, inp2 - 1)) {
				per.open(inp1 - 1, inp2 - 1);

			}
		}
		System.out.println(per.percolates());
	}
}