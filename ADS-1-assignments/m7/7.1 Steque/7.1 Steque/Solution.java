import java.util.Scanner;
class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){

    }
    /**
     * reads the input
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int numb = sc.nextInt();
        sc.nextLine();
        int i = 0;
        Steque stq = new Steque();
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String[] arr1 = str1.split(" ");
            switch (arr1[0]) {
            case "pop":
                stq.pop();
                break;
            case "push":
                stq.push(Integer.parseInt(arr1[1]));
                break;
            case "enqueue":
                stq.enqueue(Integer.parseInt(arr1[1]));
                break;
            default:
                stq = new Steque();
                System.out.println();
                break;
            }
        }

    }
}


