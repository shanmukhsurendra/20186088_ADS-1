import java.util.Scanner;
/**
 * class for Solution i.e input handling.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { This is main method to Handle the inputs }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        TeamAdd addTeam = new TeamAdd();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            addTeam.add(tokens);
        }
        addTeam.selectionSort();
        addTeam.print();

    }
}
/**
 * Class for team.
 */
class Team {
    /**
     * { Team name }.
     */
    private String name;
    /**
     * { Number of matches won by team }.
     */
    private int wins;
    /**
     * { number of matches lost }.
     */
    private int loses;
    /**
     * { number of matches tie }.
     */
    private int draws;
    /**
     * Constructs the object.
     *
     * @param      info  The information is String array
     *           which contains team name, wins, loses, draws
     */
    Team(final String[] info) {
        int i = 0;
        name = info[i];
        wins = Integer.parseInt(info[++i]);
        loses = Integer.parseInt(info[++i]);
        draws = Integer.parseInt(info[++i]);
    }
    /**
     * Gets the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return wins;
    }
    /**
     * Gets the loses.
     *
     * @return     The loses.
     */
    public int getLoses() {
        return loses;
    }
    /**
     * Gets the draws.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return draws;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }

}
/**
 * Class for team add.
 */
class TeamAdd {
    /**
     * { Team class array of objects }.
     */
    private Team[] teams;
    /**
     * { size of Team array }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    TeamAdd() {
        final int ten = 10, zero = 0;
        teams = new Team[ten];
        size = zero;
    }
    /**
     * adds new team into array..
     *
     * @param      info  The information
     */
    public void add(final String[] info) {
        teams[size++] = new Team(info);
    }
    
    /**
     * sorts the team based on size.
     */
    public void selectionSort() {
        SelectionSort sort = new SelectionSort();
        teams = sort.SelectionSort(teams, size);
    }
    /**
     * prints the result.
     */
    public void print() {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(teams[i].getName() + ",");
        } System.out.println(teams[size - 1].getName());
    }
}
/**
 * Class for selection sort.
 */
class SelectionSort {
    /**
     * Constructs the object.
     */
    SelectionSort() {

    }
    /**
     * sorts the teams based on the wins.
     *
     * @param      teams  The teams
     * @param      size   The size
     *
     * @return     returns sorted tema array.
     */
    public Team[] SelectionSort(Team[] teams, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (compareTo(teams[i].getWins(), teams[j].getWins()) > 0) {
                    swap(i, j,teams);
                } else if (compareTo(teams[i].getWins(), teams[j].getWins()) == 0) {
                    if (compareTo(teams[i].getLoses(), teams[j].getLoses()) < 0) {
                        swap(i, j,teams);
                    } else if (teams[i].getLoses() == teams[j].getLoses()) {
                        if (compareTo(teams[i].getDraws(), teams[j].getDraws()) > 0) {
                            swap(i, j,teams);
                        }
                    }
                }
            }
        }
        return teams;
    }
    /**
     * swaps the index positions..
     *
     * @param      index1  The index 1
     * @param      index2  The index 2
     */
    public void swap(final int index1, final int index2,Team[] teams) {
        Team temp;
        temp = teams[index1];
        teams[index1] = teams[index2];
        teams[index2] = temp;
    }
    /**
     * compare the avlues.
     *
     * @param      a     integer variable.
     * @param      b     integer variable.
     *
     * @return     returns 0 or 1.
     */
    public int compareTo(final int a,final int b) {
        if (a < b) {
            return 1;
        } else if (a == b) {
            return 0;
        } else{
            return -1;
        }
    }
}