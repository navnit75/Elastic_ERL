import com.sun.source.tree.Tree;

/**
 * This is a class representing an AVL Tree.
 * Its has all the related operation related to AVL Trees
 * Supports templating , but only for those classes which implements
 * Comparable.
 */
class AvlTrees<T extends Comparable<T>> {

    /**
     * This is a class represents a Node in AVL Tree
     */
    private TreeNode<T> rootNode;
    private static class TreeNode<T> {
        T data; // Data stored in the node
        int height;
        TreeNode<T> left; // Left child node
        TreeNode<T> right; // Right child node

        /**
         * Constructor to create a TreeNode object with the given any provided type
         *
         * @param data  The element which has to be used as BST node later
         */
        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
            height= 1;
        }
    }

    /**
     * Constructor to instantiate the AVL tree
     */
    public AvlTrees() {
        rootNode = null;
    }

    /**
     * Gets the height of the AVL tree provided the root node
     * @param node  : Root of the tree whose height needs to be found
     */
    private int getHeight(TreeNode<T> node) {
        if(node == null)
            return 0;
        return node.height;
    }

    /**
     * MAX utlility for finding the max between two numbers
     * @param leftNodeHeight: The first number
     * @param rightNodeHeight: The second number
     */
    private int max(int leftNodeHeight, int rightNodeHeight) {
        return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
    }

    /**
     * Update height utility for the updating the height of a node
     * after the rotation operation
     * @param node: The node for which height update operation will take place
     */
    private void updateHeight(TreeNode<T> node){
        if(node == null)
            return;
        node.height = max(getHeight(node.left),getHeight(node.right)) + 1;
    }


    /**
     * Right rotation operation on the  node provided
     * @param node: The node for which right rotation operation will take place
     * @return TreeNode<T> : Returns the new node structure after the operation
     */
   private TreeNode<T> rightRotate(TreeNode<T> node) {
       TreeNode<T> newRoot = node.left;
       node.left = newRoot.right;
       newRoot.right = node;
       updateHeight(node);
       updateHeight(newRoot);
       return newRoot;
    }

    /**
     * Left rotation operation on the  node provided
     * @param node: The node for which left rotation operation will take place
     * @return TreeNode<T> : Returns the new node structure after the operation
     */
    private TreeNode<T> leftRotate(TreeNode<T> node) {
        TreeNode<T> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    /**
     * Balance operation on the unbalanced node
     * @param node: The unbalanced node
     * @return TreeNode<T> : Returns the new node structure after the operation
     */
    private TreeNode<T> balance(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        updateHeight(node);
        int balanceFactor = getHeight(node.left) - getHeight(node.right);
        if (balanceFactor > 1) {
            if (getHeight(node.left.left) >= getHeight(node.left.right)) {
                node = rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (getHeight(node.right.right) >= getHeight(node.right.left)) {
                node = leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        return node;
    }

    /**
     * Insert element in the AVL tree
     * @param data: The element to be inserted to the AVL trees
     */
    public void insertElement(T data) {
        rootNode = insertElementHelper(rootNode,data);
    }

    /**
     * Insert operation helper for the insert function
     * @param data: The element to be inserted to the AVL trees
     * @param node: The root element of the AVL tree
     */
    private TreeNode<T> insertElementHelper(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertElementHelper(node.left, data);
        } else if (cmp > 0) {
            node.right = insertElementHelper(node.right, data);
        } else {
            return node; // Duplicate keys not allowed
        }
        return balance(node);
    }

    /**
     * Use to Search provided element in the AVL tree
     * @param key: The element to be searched
     * @returns T: Searched key if found
     */
    public T searchElement(T key) {

        TreeNode<T> searchNode = searchElement(rootNode, key);
        if(searchNode == null) return null;
        else return searchNode.data;
    }



    /**
     * Search key helper for the above function
     * @param key: The element to be searched
     * @param head: The root of the tree
     * @returns T : The element found in the tree
     */
    private TreeNode<T> searchElement(TreeNode<T> head, T key)    {
        if(head == null)
                return null;

        int compare = key.compareTo(head.data);
        if(compare < 0)
           return searchElement(head.left,key);
        else if(compare > 0)
            return searchElement(head.right,key);
        else {
            System.out.println(head.data);
            return head;
        }

    }

    /**
     * Inorder traversal of the AVL Tree
     * @returns ArraySequence<T> : Inorder sequence of the AVL Tree
     */
    public ArraySequence<T> inorderTraversal()
    {
        ArraySequence<T> returnValue = new ArraySequence<T>();
        inorderTraversal(rootNode,returnValue);
        return returnValue;
    }

    /**
     * Inorder traversal helper for inorder operation
     * @param head : Root of the AVL tree
     * @param arr : Sequence structure in which the elements have to be stored
     */
    private void inorderTraversal(TreeNode<T> head,ArraySequence<T> arr) {
        if (head != null)
        {
            inorderTraversal(head.left,arr);
            arr.add(head.data);
            inorderTraversal(head.right,arr);
        }
    }

    /**
     * Remove element operation from AVL tree
     * @param key : Element to be removed from AVL Tree
     * @return TreeNode<T> : New root after the remove operation
     */
    public TreeNode<T> removeElement(T key){
        return remove(rootNode,key);
    }

    /**
     * Remove element operation helper for AVL tree
     * @param key : Element to be removed from AVL Tre
     * @param root : Root of the AVL tree
     * @return TreeNode<T> : New root after the remove operation
     */
    private TreeNode<T> remove(TreeNode<T> root, T key) {

        if(root == null)
            return root;
        if(key.compareTo(root.data) < 0)
            root.left = remove(root.left, key);
        else if(key.compareTo(root.data) > 0)
            root.right = remove(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                TreeNode<T> temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                TreeNode<T> temp = findMinKey(root.right);
                root.data = temp.data;
                root.right = remove(root.right, temp.data);
            }
        }
        balance(root);
        return root;
    }

    /**
     * This function finds the inorder successor for the deleted node
     * @param n : To be deleted node
     * @return TreeNode<T> : The inorder successor node of the tree
     */
    private TreeNode<T> findMinKey(TreeNode<T> n) {
        TreeNode<T> target = n;
        while(target.left != null)
            target = target.left;
        return target;
    }

}

