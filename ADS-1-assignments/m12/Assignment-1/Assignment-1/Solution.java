import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * reads the input end of the file.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Final fi = new Final();
		Scanner sca = new Scanner(System.in);
		int N = Integer.parseInt(sca.nextLine());
		int vacancies = Integer.parseInt(sca.nextLine());
		int open = Integer.parseInt(sca.nextLine());
		int bc = Integer.parseInt(sca.nextLine());
		int sc = Integer.parseInt(sca.nextLine());
		int st = Integer.parseInt(sca.nextLine());
		fi.addVacancies(vacancies, open, bc, sc, st);
		for (int i = 0; i < N; i++) {
			String[] arr1 = sca.nextLine().split(",");
			fi.add(new Student(arr1[0], arr1[1], Integer.parseInt(arr1[2]),
			                   Integer.parseInt(arr1[3]),
			                    Integer.parseInt(arr1[4]),
			                     Integer.parseInt(arr1[5]),
			                   arr1[6]));
		}
		fi.sort();
		fi.print();
		System.out.println();
		fi.allotment();
	}
}
/**
 * Class for student.
 */
class Student {
	String name;
	int subject1;
	int subject2;
	int subject3;
	String[] birthDate;
	String dateOfBirth;
	int tot;
	String catagory;
	/**
	 * Constructs the object.
	 */
	Student() {

	}
	/**
	 * Constructs the object.
	 *
	 * @param      sName     The s name
	 * @param      dob1      The dob 1
	 * @param      subOne    The sub one
	 * @param      subTwo    The sub two
	 * @param      subThree  The sub three
	 * @param      total     The total
	 * @param      category  The category
	 */
	Student(String sName, String dob1, int subOne, int subTwo,
	        int subThree, int total, String category) {
		this.name = sName;
		this.dateOfBirth = dob1;
		this.subject1 = subOne;
		this.subject2 = subTwo;
		this.subject3 = subThree;
		this.tot = total;
		this.catagory = category;
		dateSort();

	}
	/**
	 * comapre the given data based on requirements.
	 *
	 * @param      data  The data
	 *
	 * @return     returns 1 or -1 or 0.
	 */
	public int compareTo(Student data) {
		if (this.tot < data.tot) {
			return 1;
		}
		if (this.tot > data.tot) {
			return -1;
		} else {
			if (this.subject3 < data.subject3) {
				return 1;
			}
			if (this.subject3 > data.subject3) {
				return -1;
			} else {
				if (this.subject2 < data.subject2) {
					return -1;
				}
				if (this.subject2 > data.subject2) {
					return 1;
				} else {
					if (this.date[2] < data.date[2]) {
						return 1;
					}
					if (this.date[2] > data.date[2]) {
						return -1;
					} else {
						if (this.date[1] < data.date[1]) {
							return 1;
						}
						if (this.date[1] > data.date[1]) {
							return -1;
						} else {
							if (this.date[0] < data.date[0]) {
								return 1;
							}
							if (this.date[0] > data.date[0]) {
								return -1;
							}
						}
					}
					return 0;
				}

			}
		}

	}
	int[] date;
	/**
	 * sorts the given date
	 */
	public void dateSort() {
		birthDate = this.dateOfBirth.split("-");
		date = new int[birthDate.length];
		for (int i = 0; i < birthDate.length; i++) {
			date[i] = Integer.parseInt(birthDate[i]);
		}
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str;
		str = this.name + "," + this.tot + "," + this.catagory;
		return str;
	}
	/**
	 * Gets the category.
	 *
	 * @return     The category.
	 */
	public String getCategory() {
		return this.catagory;
	}
}
/**
 * Class for final.
 */
class Final {
	int size;
	int vacancies;
	int open;
	Student[] students;
	int bc;
	int sc;
	int st;
	/**
	 * Constructs the object.
	 */
	Final() {
		students = new Student[20];
		size = 0;
	}
	/**
	 * Adds a vac.
	 *
	 * @param      vace   The vace
	 * @param      openr  The openr
	 * @param      bc1    The bc 1
	 * @param      sc1    The screen 1
	 * @param      st1    The st 1
	 */
	public void addVacancies(int vace, int openr, int bc1, int sc1, int st1) {
		this.vacancies = vace;
		this.open = openr;
		this.bc = bc1;
		this.sc = sc1;
		this.st = st1;
	}
	/**
	 * adds the data to the array.
	 *
	 * @param      data2  The data 2
	 */
	public void add(Student data2) {
		if (students.length == size) {
			resize();
		}
		students[size++] = data2;
	}
	/**
	 * sorts the given data by insertion.
	 */
	public void sort() {
		Insertion insert = new Insertion();
		insert.sort(students, size);
	}
	/**
	 * resize array if array is full.
	 */
	public void resize() {
		students = Arrays.copyOf(students, students.length + 1);
	}
	/**
	 * print the array elements.
	 */
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(students[i].toString());
		}
	}
	/**
	 * prints the students based on priorities.
	 */
	public void allotment() {
		int i;
		int bcCount = 0;
		int scCount = 0;
		int stCount = 0;
		for (i = 0; i < open; i++) {
			System.out.println(students[i].toString());
		}
		int l = i;
		while (stCount < st && l < size) {
			if (students[l].getCategory().equals("ST")) {
				System.out.println(students[l].toString());
				stCount++;
			}
			l++;
		}
		int k = i;
		while (scCount < sc && k < size) {
			if (students[k].getCategory().equals("SC")) {
				System.out.println(students[k].toString());
				scCount++;
			}
			k++;
		}
		int j = i;
		while (bcCount < bc && j < size) {
			if (students[i].getCategory().equals("BC")) {
				System.out.println(students[j].toString());
				bcCount++;
			}
			j++;
		}


	}
}
/**
 * Class for insertion.
 */
class Insertion {
/**
 * Constructs the object.
 */
	public Insertion() {

	}
	/**
	 * sorts the data.
	 *
	 * @param      a     { parameter_description }
	 * @param      val   The value
	 */
	public void sort(Student[] a, int val) {
		//System.out.println("batman  here");
		for (int i = 1; i < val; i++) {
			//System.out.println("super man here");
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				//System.out.println("wonderwomen here");
				exchange(a, j, j - 1);
			}
		}
	}
	/**
	 * compares the values.
	 *
	 * @param      b1    The b 1
	 * @param      b2    The b 2
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean less(Student b1, Student b2) {
		return b1.compareTo(b2) < 0;

	}
	/**
	 * swaps the elements.
	 *
	 * @param      a     { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	public void exchange(Student[] a, int i, int j) {
		Student swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
