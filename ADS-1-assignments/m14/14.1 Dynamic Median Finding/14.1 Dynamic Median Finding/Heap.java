import java.util.Arrays;
class Heap {

    Heap(){

    }
    public void sort(int[] array, int size){
        for(int i = (size/2)-1; i>=0; i--){
            heapify(array, size, i);
        }
        for(int i = size-1; i>=0; i--){
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
    public void swap(int[] array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void heapify(int[] array, int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l<n && array[l] > array[largest]){
            largest = l;
        }
        if (r < n && array[r] > array[largest]){
            largest = r;
        }
        if(largest != i){
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }
}
