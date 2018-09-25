import java.util.*;
import java.io.*;
import java.lang.*;
class Percolation {
	int count;
	int[][] mainArra;
	int size;
	int bottom;
	int top = 0;
	UF uf;
	public Percolation(int n) {
		mainArra = new int[n][n];
		size = n;
		bottom = n*n+1;
		uf = new UF(n * n + 2);
		//System.out.println(Arrays.deepToString(mainArra));
	}
	public int getIndex(int row, int column) {
		return (row) * size + column+1;
	}
	public boolean isOpen(int row, int column) {
		/*int temp = mainArra[row][column];
		System.out.println(temp);*/
		//System.out.println(row+"    "+column);
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
			uf.union(top,getIndex(row, column));
		}
		if(row == size-1){
			uf.union(getIndex(row, column), bottom);
		}
		if (column != 0) {
			if (isOpen(row, column - 1)) {
				uf.union(getIndex(row, column), getIndex(row, column - 1));
			}
		}
		if (column != size-1) {
			if (isOpen(row, column + 1)) {
				uf.union(getIndex(row, column), getIndex(row, column + 1));
			}
		}
		if (row != 0) {
			if (isOpen(row - 1, column)) {
				uf.union(getIndex(row, column), getIndex(row - 1, column));
			}
		}
		if (row != size-1) {
			if (isOpen(row + 1, column)) {
				uf.union(getIndex(row, column), getIndex(row + 1, column));
			}
		}
		//System.out.println(Arrays.deepToString(mainArra));
	}
	public int numberOfOpenSites() {
		return count;
	}
	public boolean isFull(int row, int column) {
		return uf.connected(top, getIndex(row, column));
	}
	public boolean percolates(){
		//System.out.println(top);
		return uf.connected(top,bottom);

	}
}