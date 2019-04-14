import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Steque s = new Steque();
		int i = 0;
		while (i < n){
			String inp = sc.nextLine();
			String[] arr = inp.split(" ");
			switch(arr[0]) {
				case "push":
					s.push(Integer.parseInt(arr[1]));
					break;
				case "pop":
					s.pop();
					break;
				case "enqueue":
					s.enqueue(Integer.parseInt(arr[1]));
					break;
				default:
					break;

			}
		}
	}
}