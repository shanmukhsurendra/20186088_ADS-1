import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * Sum.
     */
    private final int sum;
    /**
     * Number-1.
     */
    private final int i;
    /**
     * Number-2.
     */
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      ik    number-1
     * @param      jk    number-2
     */
    CubeSum(final int ik, final int jk) {
        this.sum = ik * ik * ik + jk * jk * jk;
        this.i = ik;
        this.j = jk;
    }
    /**
     * Compares the sum.
     *
     * @param      that  The that
     *
     * @return     integer
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Gets the number-1.
     *
     * @return     integer
     */
    int geti() {
        return this.i;
    }
    /**
     * Gets the number-2.
     *
     * @return     integer
     */
    int getj() {
        return this.j;
    }
    /**
     * Get the sum.
     *
     * @return     returns sum
     */
    int getsum() {
        return this.sum;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
}
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
class MinPQ<Key> implements Iterable<Key> {
    /**
     * store items at indices 1 to n.
     */
    private Key[] pq;
    /**
     * number of items on priority queue.
     */
    private int n;
    /**
     * optional comparator.
     */
    private Comparator<Key> comparator;

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    MinPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparators the order in which to compare the keys
     */
    MinPQ(final int initCapacity, final Comparator<Key> comparators) {
        this.comparator = comparators;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparators the order in which to compare the keys
     */
    MinPQ(final Comparator<Key> comparators) {
        this(1, comparators);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * <p>
     *
     * @param  keys the array of keys
     */
    MinPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMinHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return pq[1];
    }

    /**
     * Resize the array.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     */
    public void insert(final Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }

    /**
     * Removes and returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException(
            "Priority queue underflow");
        }
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        final int four = 4;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        assert isMinHeap();
        return min;
    }
    /**
     * Move elements uppwards.
     *
     * @param      ka    Root
     */
    private void swim(final int ka) {
        int k = ka;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * Move element downwards.
     *
     * @param      ka     Root
     */
    private void sink(final int ka) {
        int k = ka;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * Compares the two variables.
     *
     * @param      i     value-1
     * @param      j     value-2
     *
     * @return     True or False.
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * Exchanges the two integers.
     *
     * @param      i     Root
     * @param      j     Child
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * Determines if minimum heap.
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }
    /**
     * Determines if minimum heap.
     *
     * @param      k     size
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(final int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left)) {
            return false;
        }
        if (right <= n && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }
    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in ascending order.
     * <p>
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }
    /**
     * Class for heap iterator.
     */
    private class HeapIterator implements Iterator<Key> {
        /**
         * Min Priority cube.
         */
        private MinPQ<Key> copy;
        /**
         * Constructs the object.
         */
        HeapIterator() {
            if (comparator == null) {
                copy = new MinPQ<Key>(size());
            } else {
                copy = new MinPQ<Key>(size(), comparator);
            }
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        /**
         * Removes the node.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * Returns the next key.
         *
         * @return     { description_of_the_return_value }
         */
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Nothing happens here
    }
    /**
     * Returns the results.
     *
     * @param      list  The list
     * @param      numer   The number
     * @param      rep   The rep
     *
     * @return     Result
     */
    static int taxinumber(final ArrayList<CubeSum> list,
        final int numer, final int rep) {
        int num = numer;
        int i = 0;
        int res = 0;
        while (num != 0 && i < list.size() - rep + 1) {
            ArrayList<CubeSum> sub = new ArrayList<CubeSum>(
                list.subList(i++, i + rep - 1));
            HashSet<Integer> set = new HashSet<Integer>();
            for (CubeSum cs: sub) {
                set.add(cs.getsum());
            }
            if (set.size() == 1) {
                res = sub.get(0).getsum();
                num--;
            }
        }
        return res;
    }
    /**
     * The main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int number = 1000;
        Scanner s = new Scanner(System.in);
        ArrayList<CubeSum> cube = new ArrayList<CubeSum>();
        MinPQ<CubeSum> min = new MinPQ<CubeSum>();
        for (int i = 1; i < number; i++) {
            min.insert(new CubeSum(i, i));
        }
        while (!min.isEmpty()) {
            CubeSum cs = min.delMin();
            cube.add(cs);
            if (cs.getj() < number) {
                min.insert(new CubeSum(cs.geti(), cs.getj() + 1));
            }
        }
        int numer = s.nextInt();
        int repeat = s.nextInt();
        System.out.println(taxinumber(cube, numer, repeat));
    }
}