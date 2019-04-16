import java.util.Scanner;
import java.util.ArrayList;

class Team {
	String name;
	int win;
	int loss;
	int draws;
	Team (String name, int win, int loss, int draws) {
		this.name = name;
		this.win = win;
		this.loss = loss;
		this.draws = draws;
	}
	String getName() {
		return this.name;
	}
	int getWin() {
		return this.win;
	}
	int getloss() {
		return this.loss;
	}
	int getdraws() {
		return this.draws;
	}
	public String toString() {
		String str = this.name + "," + this.win + "," + this.loss + "," + this.draws;
		return str;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Team> tl = new ArrayList<>();
		while (sc.hasNext()) {
			String inp = sc.nextLine();
			String[] arr = inp.split(",");
			Team t = new Team( arr[0],  Integer.parseInt(arr[1]),  Integer.parseInt(arr[2]),  Integer.parseInt(arr[3]));
			tl.add(t);
		}
		for (Team t : tl) {
			System.out.println(t);
		}
	}
}