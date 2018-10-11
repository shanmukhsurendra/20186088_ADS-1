import java.util.Scanner;
/**
 * Class for symbol table.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SymbolTable<Key extends Comparable<Key>, Value> {
    /**
     * keys array.
     */
    private Key[] keys;
    /**
     * values array.
     */
    private Value[] values;
    /**
     * no of elemnts inserted till.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    SymbolTable(final int n) {
        keys = (Key[]) new Comparable[n];
        values = (Value[]) new Object[n];
        size = 0;
    }
    /**
     * inserts a key-value pair.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      key    The key
     * @param      value  The value
     */
    void put(final Key key, final Value value) {
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }
    /**
     * contains.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * gets function.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    Value get(final Key key) {
        if (size == 0) {
            return null;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }
    /**
     * rank.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    int rank(final Key key) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * max.
     * Best case: O(1)
     * Worst case: O(1)
     * Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    Key max() {
        return keys[size - 1];
    }
    /**
     * deletes.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      key   The key
     */
    void delete(final Key key) {
        if (size == 0) {
            return;
        }
        int i = rank(key);
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }
        int j;
        for (j = i; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[j] = null;
        values[j] = null;
    }
    /**
     * deletes min value.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     */
    void deleteMin() {
        delete(keys[0]);
    }
    /**
     * prints all values.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     */
    void keys() {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                System.out.println(keys[i] + " " + values[i]);
            }
        }
    }
    /**
     * floor.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    Key floor(final Key key) {
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }
}
/**
 * class for Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        SymbolTable<String, Integer> st = new
            SymbolTable<String, Integer>(input.length);
        for (int i = 0; i < input.length; i++) {
            st.put(input[i], i);
        }
        while (sc.hasNextLine()) {
            String[] operation = sc.nextLine().split(" ");
            switch (operation[0]) {
            case "contains":
                System.out.println(st.contains(operation[1]));
                break;
            case "get":
                System.out.println(st.get(operation[1]));
                break;
            case "max":
                System.out.println(st.max());
                break;
            case "floor":
                System.out.println(st.floor(operation[1]));
                break;
            case "rank":
                System.out.println(st.rank(operation[1]));
                break;
            case "deleteMin":
                st.deleteMin();
                break;
            case "keys":
                st.keys();
                break;
            default:
                break;
            }
        }
    }
}
