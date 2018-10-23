import java.util.NoSuchElementException;
/**
 * Class for book.
 */
class Book {
    /**
     * name.
     */
    private String name;
    /**
     * author.
     */
    private String author;
    /**
     * price.
     */
    private Double price;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      a     { parameter_description }
     * @param      p     { parameter_description }
     */
    Book(final String n, final String a, final Double p) {
        this.name = n;
        this.author = a;
        this.price = p;
    }
    /**
     * get name.
     *
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * get suthor.
     *
     * @return     { description_of_the_return_value }
     */
    String getauthor() {
        return this.author;
    }
    /**
     * get price.
     *
     * @return     { description_of_the_return_value }
     */
    Double getprice() {
        return this.price;
    }
    /**
     * compare.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    int compareTo(final Book that) {
        if (this.name.compareTo(that.name) > 0) {
            return 1;
        } else if (this.name.compareTo(that.name) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s = name + ", " + author + ", " + price;
        return s;
    }
}
/**
 * Class for binary search tree.
 */
public class BinarySearchTree {
    /**
     * Class for node.
     */
    class Node {
        /**
         * key.
         */
        private Book key;
        /**
         * value.
         */
        private Integer value;
        /**
         * left.
         */
        private Node left;
        /**
         * right.
         */
        private Node right;
        /**
         * size.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      k     { parameter_description }
         * @param      v     { parameter_description }
         * @param      size1  The size
         */
        Node(final Book k, final Integer v, final int size1) {
            this.key = k;
            this.value = v;
            this.left = null;
            this.right = null;
            this.size = size1;
        }
    }
    /**
     * root.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * size of tree.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size(root);
    }
    /**
     * size of subtree.
     *
     * @param      x     node.
     *
     * @return     integer value.
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * put.
     *
     * @param      key    The key
     * @param      value  The value
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     */
    public void put(final Book key, final Integer value) {
        root = put(root, key, value);
    }
    /**
     * put.
     *
     * @param      x      { parameter_description }
     * @param      key    The key
     * @param      value  The value
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final Book key, final Integer value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    /**
     * get.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
	 * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)     
     */
    public Integer get(final Book key) {
        return get(root, key);
    }
    /**
     * get.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     */
    private Integer get(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        }
        return x.value;
    }
    /**
     * min value.
     *
     * @return     { description_of_the_return_value }
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     */
    public Book min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls min() with empty symbol table");
        }
        return min(root).key;
    }
    /**
     * min value.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    /**
     * max value.
     *
     * @return     { description_of_the_return_value }
     */
    public Book max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls max() with empty symbol table");
        }
        return max(root).key;
    }
    /**
     * max value.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * floor.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     */
    public Book floor(final Book key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls floor() with empty symbol table");
        }
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * floor.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     * @return     { description_of_the_return_value }
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * ceiling.
     *
     * @param      key   The key
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     * @return     { description_of_the_return_value }
     */
    public Book ceiling(final Book key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to ceiling() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException(
                "calls ceiling() with empty symbol table");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }

    }
    /**
     * ceiling.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     * @return     { description_of_the_return_value }
     */
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**
     * select.
     *
     * @param      k     { parameter_description }
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     * @return     { description_of_the_return_value }
     */
    public Book select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException(
                "argument to select() is invalid: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }
    /**
     * Return key of rank k.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    /**
     * rank.
     *
     * @param      key   The key
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     * @return     { description_of_the_return_value }
     */
    public int rank(final Book key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to rank() is null");
        }
        return rank(key, root);
    }
    /**
     * Number of keys in the subtree less than key.
     *
     * @param      key   The key
     * @param      x     { parameter_description }
     * Best case: O(logN).
     * Average case:O(logN).
     * Worst case: O(N)
     * @return     { description_of_the_return_value }
     */
    private int rank(final Book key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);

        } else {
            return size(x.left);
        }
    }
}




