import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
/**.
 * Solution class
 */
final class Solution {
    /**.
     * Solution class constructor
     */
    private Solution() {
        //Constructor
    }
    /**.
     * Main method to handle the input testcases
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int noCategry = Integer.parseInt(scan.nextLine());
        int noOfBC = Integer.parseInt(scan.nextLine());
        int noOfSC = Integer.parseInt(scan.nextLine());
        int noOfST = Integer.parseInt(scan.nextLine());

        Student[] students = new Student[n];
        for (int k = 0; k < n; k++) {
            String[] tokens = scan.nextLine().split(",");
            students[k] = new Student(
                tokens[0], tokens[1], Integer.parseInt(tokens[2]),
                Integer.parseInt(tokens[2 + 1]),
                Integer.parseInt(tokens[2 + 2]),
                Integer.parseInt(tokens[2 + 2 + 1]),
                tokens[2 + 2 + 2]);
        }

        Insertion.sort(students);
        print(students);

        allotment(students, vacancies, noCategry, noOfBC,
                  noOfSC, noOfST);
    }
    /**.
     * print method to print the input
     * complexity is O(N) as it has for loop
     *
     * @param      students  The students array
     */
    public static void print(final Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
    /**.
     * Allotment method to allocate the seats to students
     * Complexity is O(N) as it has a looping statement
     * @param      students   The students
     * @param      vacancies1  The vacancies
     * @param      noCategry1  No categry
     * @param      noBC1       No bc students
     * @param      noSC1       No sc students
     * @param      noST1      No st students
     */
    public static void allotment(final Student[] students,
                                 final int vacancies1,
                                 final int noCategry1,
                                 final int noBC1,
                                 final int noSC1,
                                 final int noST1) {
        int vacancies = vacancies1;
        int noCategry = noCategry1;
        int noBC = noBC1;
        int noSC = noSC1;
        int noST = noST1;

        int i = 0;
        int k = 0;
        int n = students.length;
        Student[] alloted = new Student[vacancies];

        for (i = 0; i < n; i++) {
            if (vacancies == 0) {
                break;
            }

            if (noCategry > 0) {
                noCategry--;
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                vacancies--;
            }

            if (noBC > 0) {
                if (students[i].getRc().equals("BC")
                    && !students[i].getAlloted()) {
                    noBC--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }

            if (noSC > 0) {
                if (students[i].getRc().equals("SC")
                    && !students[i].getAlloted()) {
                    noSC--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }

            if (noST > 0) {
                if (students[i].getRc().equals("ST")
                    && !students[i].getAlloted()) {
                    noST--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    vacancies--;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (vacancies > 0 && students[i].getRc().equals("Open")
                && !students[i].getAlloted()) {
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                vacancies--;
            }
        }

        Insertion.sort(alloted);
        print(alloted);
    }
}
/**.
 * student class which contains the information of the students
 */
class Student implements Comparable<Student> {
    /**.
     * student name
     */
    private String studentName;
    /**.
     * Varaible for date of birth
     */
    private Date db;
    /**.
     * subject 1 marks
     */
    private int m1;
    /**.
     * Subject 2 marks
     */
    private int m2;
    /**.
     * subject 3 marks
     */
    private int m3;
    /**.
     * total marks
     */
    private int tm;
    /**.
     * reservation category
     */
    private String rc;
    /**.
     * flag to check weather seat allocated
     */
    private boolean alloted;

    /**.
     * returns true, if the student is already alloted,
     * otherwise false.
     *
     * @return true if alloted, otherwise false.
     */
    public boolean getAlloted() {
        return alloted;
    }

    /**.
     * Changes the alloted status to true once the allotment is done.
     *
     * @param      allot  should be either true or false.
     */
    public void setAlloted(final boolean allot) {
        this.alloted = allot;
    }

    /**.
     * Gets the data of birth.
     * @return date of birth.
     */
    public Date getDb() {
        return db;
    }

    /**.
     * sets the student's date of birth.
     *
     * @param      b     [description]
     */
    public void setDb(final Date b) {
        this.db = b;
    }

    /**.
     * gets the date of birth.
     *
     * @return     the student's date of birth.
     */
    public String getRc() {
        return rc;
    }

    /**.
     * Sets the student's reservation category.
     *
     * @param      r     { parameter_description }
     */
    public void setRc(final String r) {
        this.rc = r;
    }

    /**.
     * gets the total marks.
     * @return returns the total marks of the student.
     */
    public int getTm() {
        return tm;
    }

    /**.
     * sets the student's total marks.
     *
     * @param      m     { parameter_description }
     */
    public void setTm(final int m) {
        this.tm = m;
    }

    /**.
     * Constructs the object based on the parameters.
     *
     * @param      studentName1  Student Name
     * @param      dateOfBirth  Date of Birth
     * @param      m11           Marks in first subject.
     * @param      m21          Marks in second subject.
     * @param      m31           Marks in third subject.
     * @param      tm1          Total Marks.
     * @param      rc1          Reservation Category.
     */
    Student(final String studentName1, final String dateOfBirth,
                   final int m11, final int m21, final int m31, final int tm1,
                   final String rc1) {
        this.studentName = studentName1;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.db = sdf.parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.m1 = m11;
        this.m2 = m21;
        this.m3 = m31;
        this.tm = tm1;
        this.rc = rc1;
        this.alloted = false;
    }

    /**.
     * Gets the marks in subject 3.
     *
     * @return     m3 Marks in subject 3.
     */
    public int getM3() {
        return m3;
    }

    /**.
     * Sets the m3 to the 3rd subject.
     *
     * @param      m     { parameter_description }
     */
    public void setM3(final int m) {
        this.m3 = m;
    }

    /**.
     * Gets the marks in subject 2.
     *
     * @return     marks in subject 2.
     */
    public int getM2() {
        return m2;
    }

    /**.
     * Sets marks in subject 2.
     *
     * @param      m     { parameter_description }
     */
    public void setM2(final int m) {
        this.m2 = m;
    }

    /**.
     * Gets the marks in subject 1.
     * @return marks in subject 1.
     */
    public int getM1() {
        return m1;
    }

    /**.
     * Sets the marks to subject 1.
     *
     * @param      m     { parameter_description }
     */
    public void setM1(final int m) {
        this.m1 = m;
    }

    /**.
     * Gets the student name.
     * @return the student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**.
     * When required the student's name can be updated.
     * @param student student
     */
    public void setStudentName(final String student) {
        this.studentName = student;
    }

    /**.
     * Compares two objects of types students.
     * complexity is O(1)
     * @param  that second Student.
     * @return integer based on the requirements.
     */
    public int compareTo(final Student that) {
        if (this.getTm() > that.getTm()) {
            return -1;
        }
        if (this.getTm() < that.getTm()) {
            return 1;
        }
        if (this.getM3() > that.getM3()) {
            return -1;
        }
        if (this.getM3() < that.getM3()) {
            return 1;
        }
        if (this.getM2() > that.getM2()) {
            return -1;
        }
        if (this.getM2() < that.getM2()) {
            return 1;
        }
        if (this.getDb().compareTo(that.getDb()) < 0) {
            return 1;
        }
        if (this.getDb().compareTo(that.getDb()) > 0) {
            return -1;
        }
        return 0;
    }

    /**.
     * Gets the String version of the Students.
     * complexity is O(1)
     * @return String version of object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getStudentName() + ",");
        sb.append(this.getTm() + ",");
        sb.append(this.getRc());
        return sb.toString();
    }
}

/**.
 * insertion class
 */
final class Insertion {
  /**.
   * Insertion constructor
   */
  private Insertion() {
    //Constructor
  }
  /**.
   * { Compares weather the given element is less or not }.
   *
   * @param      v     { item1 }
   * @param      w     { item2 }
   *
   * @return     { boolean value }
   */
  private static boolean less(final Comparable v, final Comparable w) {
    return v.compareTo(w) < 0;
  }

  /**.
   * { method to exchange the inputs }.
   * complexity is O(1)
   *
   * @param      array    { array }
   * @param      item1    { index1 }
   * @param      item2     { index2 }
   */
  private static void exch(final Comparable[] array,
    final int item1, final int item2) {
    Comparable swap = array[item1];
    array[item1] = array[item2];
    array[item2] = swap;
  }

  /**.
   * Sorts the elements using insertion sort.
   * complexity is O(N^2)
   * since we have two nested for loops
   * @param array contains elements that are to be sorted.
   */
  public static void sort(final Comparable[] array) {
    int n = array.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j > 0; j--) {
        if (less(array[j], array[j - 1])) {
          exch(array, j, j - 1);
        } else {
          break;
        }
      }
    }
  }
}
