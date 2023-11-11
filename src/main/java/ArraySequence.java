import java.util.Random;

/**
 * This is a class representing a self extending Array.
 * Its has all the related operation related to Array
 * Supports templating , but only for those classes which implements
 * Comparable.
 */
class ArraySequence<T extends Comparable<T>> {
    private Object[] array;
    private static final int INITIAL_CAPACITY = 10;
    private static final int DIGITS = 8;
    private int size;
    private boolean isSorted = false;

    /**
     * Constructor to create a ArraySequence with capacity of 10
     *
     */
    public ArraySequence(){
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Checks if the base array is empty.
     * @returns boolean : if the array is empty or not
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Returns the size of the internal array
     * @returns int : Gets the size of the array
     */
    public int getSize(){
        return size;
    }

    /**
     * Adds the element into the internal array
     */
    public void add(T element){
        if(size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    /**
     * Returns the element from internal array according to the internal index
     * @param index : integer from which element has to be extracted
     * @returns T : The element extracted from the array
     */
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (T)array[index];
    }

    /**
     * Removes the element from provided index
     * @param index : index from which element has to be deleted
     */
    public void removeByIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    /**
     *
     *  Use to change the specific index value of the base array
     * @param index : The index at which new value has to be placed
     * @param element : The element which has to be placed
     * @return T : The previous element
     */
    public T set(int index, T element){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        T previousElement = (T)array[index];
        array[index] = element;
        return previousElement;
    }

    /**
     * Removes the element if the element itself is provided
     * @param element : Element which has to be deleted
     */
    public void removeByElement(T element){
        int index = binarySearch(element);
        removeByIndex(index);
//        if (index == -1) {
//            throw new IllegalArgumentException("Element is not present in the Array Sequence");
//        }
//
//        for (int i = index; i < size - 1; i++) {
//            array[i] = array[i + 1];
//        }
//        array[--size] = null;
    }

    /**
     * Resizing the internal array to occoupy more elements
     */
    private void resize() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /**
     * Searching the elements inside the internal array
     * @param element : Element to be searched
     * @returns int : index where element was found in the array
     */
    public int binarySearch(T element){
        return binarySearch(element,0,size-1);
    }

    /**
     * Search helper for the Array Sequence
     * @param element : Element to be searched
     * @param low : The first index of the array
     * @param high : The last index of the array
     * @returns int : index where element was found in the array
     */
    private int binarySearch(T element, int low , int high){
        if (high < low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        T midElement = get(mid);
        int comparison = element.compareTo(midElement);

        if (comparison == 0) {
            return mid;
        } else if (comparison < 0) {
            return binarySearch(element, low, mid - 1);
        } else {
            return binarySearch(element, mid + 1, high);
        }
    }

    /**
     * Get the previous element from the sorted list
     * @param element : Element to be searched
     * @returns T : The previous element
     */
    public T getPreviousElement(T element){
        int index = binarySearch(element);
        if(index == -1){
            throw new IllegalArgumentException("Element is not present in the Array Sequence");
        }
        if(index == 0){
            return null;
        }
        return (T)array[index - 1];
    }

    /**
     * Get the Next element from the sorted list
     * @param element : Element to be searched
     * @returns T : The next element
     */
    public T getNextElement(T element){
        int index = binarySearch(element);
        if(index == -1){
            throw new IllegalArgumentException("Element is not present in the Array Sequence");
        }
        if(index == size-1){
            return null;
        }
        return (T)array[index + 1];
    }

//    /**
//     * Applying the heapsort algorithm on the base array
//     */
//     private void heapSort() {
//        System.out.println("Size : "+ size);
//        int n = getSize();
//        for(int i = n/2 -1 ; i >= 0 ; i--){
//            heapify(n,i);
//        }
//        for(int i = n-1 ; i > 0 ; i--){
//            T temp = (T)array[0];
//            array[0] = array[i];
//            array[i] = temp;
//            heapify(i,0);
//        }
//    }

//    /**
//     * Helper for the heapsort algorithm on the base array
//     * @param n : The size of the array
//     * @param i : Element to be heapified
//     */
//    private void heapify(int n , int i){
//        int largest = i;
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//
//        T leftElement = null,rightElement = null,largestElement = null;
//        int comparison = -999;
//
//        if (left < n) {
//            leftElement = (T)array[left];
//            largestElement = (T)array[largest];
//            comparison = leftElement.compareTo(largestElement);
//
//            if(comparison > 0)
//                largest = left;
//        }
//
//
//        if (right < n) {
//            rightElement = (T)array[right];
//            largestElement = (T)array[largest];
//            comparison = rightElement.compareTo(largestElement);
//
//            if(comparison > 0)
//                largest = right;
//        }
//
//        if (largest != i) {
//            T swap = (T)array[i];
//            array[i] = array[largest];
//            array[largest] = swap;
//            heapify(n, largest);
//        }
//
//
//    }
//
//    /**
//     * Perform randomized quicksort on the base array
//     */
//    private void randomizedQuickSort() {
//        randomizedQuickSort(array,0,size-1);
//    }
//
//    /**
//     * Perform randomized quicksort on the base array
//     * @param array : The base array on which quicksort has to be applied
//     * @param high : The start index
//     * @param low  : The end index
//     */
//    private void randomizedQuickSort(Object array[],int low , int high){
//        if(low < high){
//            Random rand = new Random();
//            int pivotIndex = rand.nextInt(high-low + 1) + low;
//            T temp = (T)array[pivotIndex];
//            array[pivotIndex] = array[high];
//            array[high] = temp;
//
//            int pivot = partition(array, low, high);
//            randomizedQuickSort(array, low, pivot - 1);
//            randomizedQuickSort(array, pivot + 1, high);
//
//        }
//    }
//
//    /**
//     * Helper for the quicksort
//     * @param array : The base array on which quicksort has to be applied
//     * @param high : The start index
//     * @param low  : The end index
//     * @return int : Pivot index
//     */
//    private int partition(Object array[],int low, int high){
//        T pivot = (T)array[high]; // Choose the last element as the pivot
//        int i = low - 1; // Index of smaller element
//
//        for (int j = low; j < high; j++) {
//            // If current element is smaller than or equal to pivot
//            T currentElement = (T)array[j];
//            int comparison = currentElement.compareTo(pivot);
//            if (comparison ==0 || comparison < 0) {
//                i++;
//
//                // Swap arr[i] and arr[j]
//                T temp = (T)array[i];
//                array[i] = array[j];
//                array[j] = temp;
//            }
//        }
//
//        // Swap arr[i+1] and arr[high] (pivot)
//        T temp = (T)array[i + 1];
//        array[i + 1] = array[high];
//        array[high] = temp;
//
//        return i + 1; // Return the updated pivot index
//    }

    /**
     * Radix sort helper for sorting the array
     */
    public void radixSort() {
        if (array == null || getSize() <= 1) {
            return;
        }

        int maxDigits = DIGITS; // Maximum number of digits in input integers

        // Perform counting sort for each digit from least significant to most significant
        for (int i = 0; i < maxDigits; i++) {
            int[] counts = new int[10];
            Object[] temp = new Object[getSize()];


            for (int j = 0 ; j < getSize(); j++){
                Node value = (Node)array[j];
                int tempValue =  Integer.parseInt(value.getKey());
                int digit  = getDigit(tempValue,i);
                counts[digit]++;
            }

            for (int j = 1; j < 10; j++) {
                counts[j] += counts[j - 1];
            }

            // Place elements into appropriate positions in the temporary array
            for (int j = getSize() - 1; j >= 0; j--) {
                Node value = (Node)array[j];
                int tempValue = Integer.parseInt(value.getKey());
                int digit = getDigit(tempValue, i);
                temp[counts[digit] - 1] = array[j];
                counts[digit]--;
            }

            // Copy the sorted elements from the temporary array to the original array
            System.arraycopy(temp, 0, array, 0,  getSize());
        }
    }

    /**
     * Helper for the RadixSort to get the specific digit
     * @param digitIdx  : The index from which digit has to be obtained
     * @param value : The value from which data has to be
     * @return int : The specific index value
     */
    private  int getDigit(int value, int digitIdx) {
        return (value / (int) Math.pow(10, digitIdx)) % 10;
    }
    /**
     * Sorting the base array according to the size of the base array
     */
    public void sort() {
        radixSort();
    }
    /**
     * To String override for the self-made structure
     * @returns String : Returns the string representation of the object.
     */
    @Override
    public String toString(){
        String str = "[";
        for(int i = 0 ; i < getSize()-1; i++)
            str += (array[i]+"\n"+",");
        str += (array[getSize()-1] + "]\n");
        return str;
    }

}