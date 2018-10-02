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
        addTeam.insertionsort();
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
     * adds team objects into teams array.
     *
     * @param      info  The information
     */
    public void add(final String[] info) {
        teams[size++] = new Team(info);
    }

    /**
     * Sorting based on selection sort algorithm.
     */
    public void insertionsort() {
        Insertionsort sort = new Insertionsort();
        teams = sort.insertionsortt(teams, size);
    }
    /**
     * To display elements of the sorted array.
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
class Insertionsort {
    /**
     * Constructs the object.
     */
    Insertionsort() {

    }
    /**
     * To perform selection sort.
     *
     * @param      team  The teams
     * @param      size   The size
     *
     * @return     sorted array of team objects
     * Time complexity of This method is O(N^2)
     *  because we are using nested for loops
     *   in worst case it may go up to O(N^2)
     */
    public Team[] insertionsortt(final Team[] team, final int size) {
        Team[] teams = team;
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (compareTo(teams[j - 1].getWins(), teams[j].getWins()) > 0) {
                    swap(j - 1, j, teams);
                } else if (compareTo(teams[j - 1].getWins(),
                                     teams[j].getWins()) == 0) {
                    if (compareTo(teams[j - 1].getLoses(),
                                  teams[j].getLoses()) < 0) {
                        swap(j - 1, j, teams);
                    } else if (compareTo(teams[j - 1].getLoses(),
                                 teams[j].getLoses()) == 0) {
                        if (compareTo(teams[j - 1].getDraws(),
                                      teams[j].getDraws()) > 0) {
                            swap(j - 1, j, teams);
                        }
                    }
                }
            }
        }
        return teams;
    }
    /**
     * swapping the team objects.
     *
     * @param      index1  The index 1
     * @param      index2  The index 2
     * @param      teams   The teams
     */
    public void swap(final int index1, final int index2, final Team[] teams) {
        Team temp;
        temp = teams[index1];
        teams[index1] = teams[index2];
        teams[index2] = temp;
    }
    /**
     * compares two values.
     *
     * @param      a     { index position }
     * @param      b     { index position }
     *
     * @return     -1 if first element is less, 1 if greater and 0 if equal
     *
     */
    public int compareTo(final int a, final int b) {
        if (a < b) {
            return 1;
        } else if (a == b) {
            return 0;
        } else {
            return -1;
        }
    }
}