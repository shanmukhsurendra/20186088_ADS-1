import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numb = sc.nextInt();
        sc.nextLine();
        int i = 0;
        Steque li = new Steque();
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String[] arr1 = str1.split(" ");
            switch (arr1[0]) {
            case "pop":
                li.pop();
                break;
            case "push":
                li.push(Integer.parseInt(arr1[1]));
                break;
            case "enqueue":
                li.enqueue(Integer.parseInt(arr1[1]));
                break;
            default:
                li = new Steque();
                System.out.println();
                break;
            }
        }

    }
}