import java.util.Objects;
/**
 *
 *  The wrapper class in which our node would be stored.
 *  And later this wrapper will be recognized by the HashTable
 */

class HashNode<T extends Comparable<T>> implements Comparable<HashNode<T>> {
    T data;
    final int hashCode;

    // Reference to next node
    HashNode<T>  next;

    // Constructor
    public HashNode(T data, int hashCode)
    {
        this.data = data;
        this.hashCode = hashCode;
    }

    @Override
    public int compareTo(HashNode<T> o) {
        return data.compareTo(o.data);
    }
}


/**
 * Class to represent entire hash table
 */
class HashTable<T extends Comparable<T>> {
    // bucketArray is used to store array of chains
    private ArraySequence<HashNode<T>> bucketArray;
    private int numBuckets;
    private int size;
    /**
     * Constructor to represent HashTable class
     */
    public HashTable(){
        bucketArray = new ArraySequence<>();
        this.numBuckets = 10;
        size = 0;
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    /**
     * Get the size of the HashTable
     * @return int : Size of the hash table
     */
    public int size() { return size; }

    /**
     * Checks if the HashTable is empty
     * @return boolean : Returns if the hashtable is empty
     */
    public boolean isEmpty() { return size() == 0; }

    /**
     * Returns the unique hashcode for the key
     * @param key
     * @return int
     */
    private final int hashCode (T key) {
        Node newKey = (Node)key;
        return Objects.hashCode(newKey.getKey());
    }

    /**
     * Gets the index of the bucket, where the element has to be stored for the specific key
     * @param key
     * @return
     */
    private int getBucketIndex(T key) {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        // key.hashCode() could be negative.
        index = index < 0 ? index * -1 : index;
        return index;
    }

    /**
     * Remove the provided key from the hash table
     * @param key : Key to be removed
     * @return
     */
    public T remove(T key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<T> head = bucketArray.get(bucketIndex);
        HashNode<T> prev = null;
        while (head != null) {
            if (head.data.equals(key) && hashCode == head.hashCode)
                break;
            prev = head;
            head = head.next;
        }
        if (head == null)
            return null;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);
        return head.data;
    }

    /**
     * Search the provided key in the hash table
     * @param key : Key to be searched
     * @return T : Returns the found element
     */
    public T get(T key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<T> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.data.compareTo(key) == 0 && head.hashCode == hashCode)
                return head.data;
            head = head.next;
        }

        return null;
    }

    /**
     * Add the element to the hash table
     * @param key : Key to be added
     */
    public void add(T key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<T> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.data.equals(key) && head.hashCode == hashCode) {
                head.data = key;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<T> newNode
                = new HashNode<T>(key,hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        if ((1.0 * size) / numBuckets >= 0.7) {
            ArraySequence<HashNode<T>> temp = bucketArray;
            bucketArray = new ArraySequence<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (int i = 0 ; i < temp.getSize(); i++) {
                HashNode<T> headNode = temp.get(i);
                while (headNode != null) {
                    add(headNode.data);
                    headNode = headNode.next;
                }
            }
        }
    }

    /**
     * Function to return all the elements of the HashTable as array
     * @return ArraySequence<T> : Returns an array of the elments stored in the HashTable
     */
    public ArraySequence<T> allKeys(){
        ArraySequence<T> arr = new ArraySequence<T>();
        for(int i = 0 ; i < bucketArray.getSize(); i++){
            HashNode<T> head = bucketArray.get(i);
            while(head != null){
                arr.add(head.data);
                head = head.next;
            }
        }
        return arr;
    }

}
