import java.util.Objects;

/**
 * This is a class representing a Entity in which data has to be stored
 * This would be used for all the operations later coming up.
 */
class Node implements Comparable<Node> {
    private String key;
    private String value;

    /**
     * Constructor for the Node
     *
     * @param key: Takes the key value
     * @param value : Takes the value for the key
     */
    Node(String key , String value){
        this.key = key;
        this.value = value;
    }
    /**
     * Getter for the key
     *
     * @return String
     */
    public String getKey() {
        return key;
    }

    /**
     * Setter for the key
     *
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Getter for the Value
     *
     * @returns String
     */
    public String getValue() {
        return value;
    }

    /**
     * Setter for the value
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Check the equality of the two node object
     *
     * @param o : Object with which called object has to be compared with
     * @return boolean : If not equal return false, else return true.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return Objects.equals(key, node.key);
    }

    /**
     * To String override for the self-made structure
     * @returns String : Returns the string representation of the object.
     */
    @Override
    public String toString() {
        return "Key : " + key +
                " Value : " +  value;
    }

    /**
     * Compare to Override for using with it ArraySequence and BST
     * @returns int
     */
    @Override
    public int compareTo(Node o) {
        return this.getKey().compareTo(o.getKey());
    }
}
