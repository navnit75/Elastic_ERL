import java.util.Random;
import java.util.Set;

/**
 * This class represents ElasticERL ADT
 */
class ElasticERL<T extends Comparable<T>> {
    public ArraySequence<T> array = new ArraySequence<T>();
    public AvlTrees<T> avlTree = new AvlTrees<T>();
    public HashTable<T> hashTable = new HashTable<T>();


    private int thresholdSize;
    private boolean isHashTableSelected;

    /**
     * This functions sets the size of the internal data structures used
     * @param size : sets the size of the internal array
     */
    public void SetEINThreshold(int size) {
        if(size  <= 1000) {
            this.thresholdSize = size;
            isHashTableSelected = false;
            System.out.println("Using AVL Trees ..");
        }
        else {
            this.thresholdSize = size;
            isHashTableSelected = true;
            System.out.println("Using Hash Table .. ");

        }
    }


    public String generate(){
        if(isHashTableSelected){
            String generateValue = generateHelper();
            T searchNode = (T)new Node(generateValue,"");
            while(hashTable.get(searchNode) != null){
                generateValue = generateHelper();
                searchNode = (T)new Node(generateValue,"");
            }
            return generateValue;
        }
        else {
            String generateValue = generateHelper();
            T searchNode = (T)new Node(generateValue,"");
            while(avlTree.searchElement(searchNode) != null){
                generateValue = generateHelper();
                searchNode = (T)new Node(generateValue,"");
            }
            return generateValue;
        }
    }

    /**
     * This functions act as helper to generates a random 8-digit number
     * @returns String : return the generated string
     */
    private String generateHelper() {
        Random rnd = new Random();
        int n = 10000000 + rnd.nextInt(90000000);
        String returnValue = Integer.toString(n);
        return returnValue;
    }

    /**
     * This functions gets all the elements  present in the base structure
     * @returns ArraySequence
     */
    public ArraySequence<T> getAllKeys(){
        if(isHashTableSelected){
             array = hashTable.allKeys();
             array.sort();
             return array;
        } else {
            return avlTree.inorderTraversal();
        }
    }


    /**
     * This functions gets all the elements  present in the base structure
     * @returns ArraySequence
     */
    public ArraySequence<T> rangeKey(T key1 , T key2){
        if(isHashTableSelected){
            array = hashTable.allKeys();
            array.sort();
            return helperRangeKey(array,key1,key2);
        }
        else {
            ArraySequence<T> inorderRes = new ArraySequence<T>();
            return helperRangeKey(avlTree.inorderTraversal(),key1,key2);
        }
    }



    /**
     * Helper for the Range function
     * @param array : Array sequence
     * @param key1 : First key element
     * @param key2 : second key element
     * @returns ArraySequence
     */
    private ArraySequence<T> helperRangeKey(ArraySequence<T> array,T key1, T key2){
        ArraySequence<T> returnArray = new ArraySequence<T>();
        if(key1.compareTo(key2) < 0){
            for(int i = array.binarySearch(key1) ; i <= array.binarySearch(key2) ; i++){
                returnArray.add(array.get(i));
            }
        }
        else if(key1.compareTo(key2) > 0) {
            for(int i = array.binarySearch(key2) ; i <= array.binarySearch(key1) ; i++){
                returnArray.add(array.get(i));
            }
        }
        else {
            System.out.println("Both keys are same");
        }
        return returnArray;
    }

     /**
     * This function is used to add the elements in the base structure
     * @param node : Node which needs to be added to ElasticERL
     */
    public void add(T node){
        if(isHashTableSelected){
            hashTable.add(node);
        }
        else {
            avlTree.insertElement(node);
        }
    }

    /**
     * This function is used to remove a key element from the ElasticERL
     * @param key : The key to be removed.
     */
    public void remove(T key){
        if(isHashTableSelected){
            hashTable.remove(key);
        }
        else{
            avlTree.removeElement(key);
        }
    }

    /**
     * This function is used to getValues for the provided key element
     * @returns T : The element which is found at that place
     */
    public T getValues(T key){
        if(isHashTableSelected){
            return hashTable.get(key);
        }
        else {

            return avlTree.searchElement(key);
        }
    }

    /**
     * This function is used to get the next key from the base structure
     * @param key : The element whose next element has to be found
     * @returns T : The next element
     */
    public T getNextKey(T key){
        if(isHashTableSelected){
            array = hashTable.allKeys();
            array.sort();
            return array.getNextElement(key);
        }
        else {
            array = avlTree.inorderTraversal();
            return array.getNextElement(key);
        }
    }

    /**
     * Get the previous value from the provided structure
     * @param key : Element whose previous key has to be found
     * @returns T : The previous element
     */
    public T getPrevKey(T key){
        if(isHashTableSelected){
            array = hashTable.allKeys();
            array.sort();
            return array.getPreviousElement(key);
        }
        else {
            array = avlTree.inorderTraversal();
            return array.getPreviousElement(key);

        }
    }

}

