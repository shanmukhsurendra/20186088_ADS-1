import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for hash table.
 */
class HashTable {
    /**
     * Class for node.
     */
    class Node {
        /**
         * Word as key.
         */
        private String key;
        /**
         * Count of the word.
         */
        private Integer val;
        /**
         * The next node.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      k     Name of String.
         * @param      v     Count of the String.
         * @param      n     The next node.
         */
        Node(final String k, final Integer v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        /**
         * Gives the key.
         *
         * @return     key.
         */
        String getkey() {
            return this.key;
        }
        /**
         * Gets the value.
         *
         * @return     The value.
         */
        Integer getValue() {
            return this.val;
        }
        /**
         * Sets the value.
         *
         * @param      v     Count
         */
        void setvalue(final Integer v) {
            this.val = v;
        }
    }
    /**
     * Node array.
     */
    private Node[] st;
    /**
     * Size of the array.
     */
    private int s = (2 * (2 + 2 + 1)) * (2 * (2 + 2 + 1));
    /**
     * Constructs the object.
     */
    HashTable() {
        st = new Node[s];
    }
    /**
     * Generates the hash code.
     *
     * @param      k     Name of String.
     *
     * @return     Returns the hash code.
     */
    int hash(final String k) {
        final int con = 0x7fffffff;
        return (k.hashCode() & con) % s;
    }
    /**
     * Resizes the array.
     */
    public void resize() {
        st = Arrays.copyOf(st, 2 * s);
    }
    /**
     * Puts the value in HashTable.
     *
     * @param      k     String.
     * @param      v     Count.
     */
    public void put(final String k, final Integer v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setvalue(x.getValue() + 1);
                return;
            }
        }
        if (i >= st.length) {
            resize();
        }
        st[i] = new Node(k, v, st[i]);
    }
    /**
     * Gets the word from HashTable.
     *
     * @param      k     Word.
     *
     * @return     True, if present, else false.
     */
    public boolean get(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                if (x.getValue() > 0) {
                    x.setvalue(x.getValue() - 1);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
/**
 * Class for Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Nothing happens here.
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        HashTable h = new HashTable();
        for (int i = 0; i < m; i++) {
            h.put(magazine[i], 1);
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (!h.get(note[i])) {
                flag = false;
                System.out.println("No");
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }
    }
}



