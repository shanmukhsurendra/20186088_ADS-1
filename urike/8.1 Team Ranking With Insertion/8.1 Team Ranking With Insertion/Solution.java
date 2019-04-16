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
		String str = this.name;
		return str;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Team> tl = new ArrayList<>();
		Sort s = new Sort(); 
		while (sc.hasNext()) {
			String inp = sc.nextLine();
			String[] arr = inp.split(",");
			Team t = new Team( arr[0],  Integer.parseInt(arr[1]),  Integer.parseInt(arr[2]),  Integer.parseInt(arr[3]));
			tl.add(t);
		}
		Team[] arr1 = tl.toArray(new Team[tl.size()]);
		Team[] arr2 = s.sort(arr1);
		for (Team t : arr2) {
			System.out.print(t);
			System.out.print(",");
		}
	}
}
class Sort {
	Sort() {

	}
	public Team[] sort(final Team[] teams) {
		for (int i = 0; i < teams.length; i++) {
			for (int j = i + 1; j < teams.length; j++) {
				if (compareTo(teams[i].getWin(), teams[j].getWin()) > 0) {
					swap(i, j, teams);
				} else if (compareTo(teams[i].getWin(), teams[j].getWin()) == 0) {
					if(compareTo(teams[i].getloss(), teams[j].getloss()) < 0) {
						swap(i, j, teams);
					} else if(compareTo(teams[i].getloss(), teams[j].getloss()) == 0) {
						if(compareTo(teams[i].getdraws(), teams[j].getdraws()) > 0) {
						swap(i, j, teams);
					}
					}

				}
			}
		}
		return teams;
	}
	int compareTo(int a, int b) {
		if (a < b) {
			return 1;
		} else if (a == b) {
			return 0;
		} else {
			return -1;
		}
	}
	void swap(int i, int j, Team[] teams) {
		Team temp = teams[i];
		teams[i] = teams[j];
		teams[j] = temp;
	}
}