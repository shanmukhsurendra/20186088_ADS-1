import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 * reads the inputs gives output.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentsData = sc.nextInt();
		//System.out.println(studentsData);
		sc.nextLine();
		SeparateChainingHashST<Integer, Student> schain = new SeparateChainingHashST<>();
		Student s = new Student();
		int i = 0;
		while (i < studentsData) {
			//System.out.println("i am here 1");
			String str1 = sc.nextLine();
			String arra1[] = str1.split(",");
			s = new Student(arra1[1], arra1[2]);
			schain.put(Integer.parseInt(arra1[0]), s);
			i++;
		}
		int j = sc.nextInt();
		//System.out.println(j);
		sc.nextLine();
		int k = 0;
		while (k < j) {
			//System.out.println("i am here 2");
			String arra2[] = sc.nextLine().split(" ");
			if (arra2[2].equals("1")) {
				//System.out.println("i am in first if");
				int key = Integer.parseInt(arra2[1]);
				if (schain.contains(key)) {
					//System.out.println("i am in second if");
					System.out.println(schain.get(key).name);
				} else {
					System.out.println("Student doesn't exists...");
				}
			}
			if (arra2[2].equals("2")) {
				int key = Integer.parseInt(arra2[1]);
				if (schain.contains(key)) {
					System.out.println(schain.get(key).marks);
				} else {
					System.out.println("Student doesn't exists...");
				}
			}
			k++;
		}
	}
}
