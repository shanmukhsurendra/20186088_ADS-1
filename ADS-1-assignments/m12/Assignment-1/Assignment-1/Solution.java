import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;


// class Solution {
// 	public static void main(String[] args) {
// 		ArrayList<Student> list1 = new ArrayList<>();
// 		Scanner sc = new Scanner(System.in);
// 		int n = Integer.parseInt(sc.nextLine());
// 		int vacancies = Integer.parseInt(sc.nextLine());
// 		int openVacancies = Integer.parseInt(sc.nextLine());
// 		int bcVacancies = Integer.parseInt(sc.nextLine());
// 		int scVacancies = Integer.parseInt(sc.nextLine());
// 		int stVacancies = Integer.parseInt(sc.nextLine());
// 		//int i = 0;
// 		while(sc.hasNext()){
// 			//System.out.println("i am here");
// 			String[] arr1 = sc.nextLine().split(",");
// 			//String[] arr1 = str1.split(",");
// 			//String[] tokens = scan.nextLine().split(",");
// 			//System.out.println("array here"+Arrays.toString(arr1));
// 			Student data = new Student(arr1[0],arr1[1],arr1[2],arr1[3],arr1[4],arr1[5],arr1[6]);
// 			list1.add(s);
// 			//i++;
// 		}

// 	}
// }
// class Student{

// }
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Final fi = new Final();
		Scanner sca = new Scanner(System.in);
		int N = Integer.parseInt(sca.nextLine());
		int vac = Integer.parseInt(sca.nextLine());
		int un = Integer.parseInt(sca.nextLine());
		int bc = Integer.parseInt(sca.nextLine());
		int sc = Integer.parseInt(sca.nextLine());
		int st = Integer.parseInt(sca.nextLine());
		fi.addVac(vac, un, bc, sc, st);
		for (int i = 0; i < N; i++) {
			String[] tokens = sca.nextLine().split(",");
			fi.add(new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]),
			                          Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
			                          tokens[6]));
		}
		fi.sort();
		fi.print();
		System.out.println();
		fi.allotment();
	}
}
class Student {
	String name;
	String dob;
	int sub1;
	int sub2;
	int sub3;
	int tot;
	String cat;
	Student(){

	}
	Student(String sName, String dob1, int subOne, int subTwo,
	        int subThree, int total, String category) {
		this.name = sName;
		this.dob = dob1;
		this.sub1 = subOne;
		this.sub2 = subTwo;
		this.sub3 = subThree;
		this.tot = total;
		this.cat = category;
	}
	public int compareTo(Student obj) {
		if (this.tot < obj.tot) {
			return 1;
		}
		if (this.tot > obj.tot) {
			return -1;
		} else {
			if (this.sub3 < obj.sub3) {
				return -1;
			}
			if (this.sub3 > obj.sub3) {
				return 1;
			} else {
				if (this.sub2 < obj.sub2) {
					return 1;
				}
				if (this.sub2 > obj.sub2) {
					return -1;
				} else {
					if (this.sub1 < obj.sub1) {
						return 1;
					}
					if (this.sub1 > obj.sub1) {
						return -1;
					}
				}
			}
			return 0;
		}

	}
	public String toString() {
		String str;
		str = this.name+","+this.tot+","+this.cat;
		return str;
	}
	public String getCategory(){
		return this.cat;
	}
}
class Final {
	Student[] students;
	int size;
	int vac;
	int un;
	int bc;
	int sc;
	int st;
	Student obj1 = new Student();
	Final() {
		students = new Student[20];
		size = 0;
	}
	public void addVac(int vace, int unr, int bc1, int sc1, int st1) {
		this.vac = vace;
		this.un = unr;
		this.bc = bc1;
		this.sc = sc1;
		this.st = st1;
	}
	public void add(Student obj) {
		if (students.length == size) {
			resize();
		}
		students[size++] = obj;
	}
	public void sort(){
		Insertion insobj = new Insertion();
		insobj.sort(students);
	}
	public void resize() {
		students = Arrays.copyOf(students, students.length + 1);
	}
	public void print(){
		for(int i = 0;i<size;i++){
			System.out.println(students[i].toString());
		}
	}
	public void allotment(){
		int i;
		int countbc =0;
		int countsc = 0;
		int countst = 0;
		for(i = 0;i<un;i++){
			System.out.println(students[i].toString());
		}
		int l = i;
		while(countst<st&&l<size){
			if(students[l].getCategory().equals("ST")){
				System.out.println(students[l].toString());
				countst++;
			}
			l++;
		}
		int k = i;
		while(countsc<sc&&k<size){
			if(students[k].getCategory().equals("SC")){
				System.out.println(students[k].toString());
				countsc++;
			}
			k++;
		}
		int j = i;
		while(countbc<bc&&j<size){
			if(students[i].getCategory().equals("BC")){
				System.out.println(students[j].toString());
				countbc++;
			}
			j++;
		}
		
		
	}
}
class Insertion {

	public Insertion() {}
	public void sort(Student[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exchange(a, j, j - 1);
			}
			// System.out.println(Arrays.toString(a));

		}
	}
	public boolean less(Student b1, Student b2) {
		return b1.compareTo(b2) < 0;

	}
	public void exchange(Student[] a, int i, int j) {
		Student swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
