import java.util.Scanner;

class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentsData = sc.nextInt();
		sc.nextLine();
		RedBlackBST<Student, Integer> rb = new RedBlackBST<>();
		Student s = new Student();
		int i = 0;
		while (i < studentsData) {
			String str1 = sc.nextLine();
			String arra1[] = str1.split(",");
			s = new Student(arra1[1], arra1[2]);
			rb.put(s, Integer.parseInt(arra1[0]));
			i++;
		}
		int j = sc.nextInt();
		sc.nextLine();
		int k = 0;
		while (k < j) {
			String arra2[] = sc.nextLine().split(" ");
			if (arra2[0].equals("BE")) {
				double lower = Double.parseDouble(arra2[1]);
				double upper = Double.parseDouble(arra2[2]);
				for (Student each : rb.keys()) {
					if (each.marks >= lower && each.marks <= upper) {
						System.out.println(each.name);
					}
				}

			}
		}
	}
}
class Student implements Comparable<Student>{
	String name;
	double marks;
	
	Student() {

	}
	Student(String n, String m) {
		this.name  = n;
		this.marks = Double.parseDouble(m);
	}
	public int compareTo(Student that) {
		if (this.marks > that.marks) return 1;
		if (this.marks < that.marks) return -1;
		if (this.name.compareTo(that.name) > 0) return 1;
		if (this.name.compareTo(that.name) < 0) return -1;
		return 0;
	}
}