/** 
 * A Node class for a binary search tree
 * @author Jake Model
 */

public class Node {
    int key;
    Node left, right;

    /** 
     * Constructor for a Node
     * @param int item
     */
    public Node(int item) {
        key = item;
        left = null;
        right = null;
    }

    /**
     * Get key of node
     * @return key
     */
    public int getKey() {
        return this.key;
    }

    /**
     * Get left child
     * @return left child
     */
    public Node getLeft() {
        return this.left;
    }

    /**
     * Set left child 
     * @param Node left
    */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Get right child
     * @return Node right
     */
    public Node getRight() {
        return this.right;
    }

    /** 
     * Set right child
     * @param Node right
     */
    public void setRight(Node right) {
        this.right = right;
    }
}
