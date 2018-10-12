/**
 *the class is for performing dynamic median.
 */
class DynamicMedian {
    /**
     *the object to access of minheap.
     */
    private MinPQ<Double> min;
    /**
     *the object to access of maxheap.
     */
    private MaxPQ<Double> max;
    /**
     *the constructor for initializing.
     */
    DynamicMedian() {
        min = new MinPQ<Double>();
        max = new MaxPQ<Double>();
    }
    /**
     *the method will insert the element
     *to minheap.
     * @param      item  The item
     */
    public void insertAtMin(final double item) {
        min.insert(item);
    }
    /**
     *the method will insert the element
     *to maxheap.
     * @param      item  The item
     */
    public void insertAtMax(final double item) {
        max.insert(item);
    }
    /**
     *this method gets the minimum element.
     * from minheap.
     * @return     The minimum.
     */
    public double getMin() {
        return min.min();
    }
    /**
     *this method gets the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double getMax() {
        return max.max();
    }
    /**
     *this method delete the maximum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double delMax() {
        return max.delMax();
    }
    /**
     *this method delete the minimum element.
     * from maxheap.
     * @return     The minimum.
     */
    public double delMin() {
        return min.delMin();
    }
    /**
     *gets the size of minheap.
     *
     * @return     The minimum size.
     */
    public int getMinSize() {
        return min.size();
    }
    /**
     * Gets the maximum size of maxheap.
     *
     * @return     The maximum size.
     */
    public int getMaxSize() {
        return max.size();
    }
}