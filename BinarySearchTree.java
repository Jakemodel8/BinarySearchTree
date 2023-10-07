import java.util.*;

/** 
 * A class to create a binary tree
 * @author Jake Model
 */

 public class BinarySearchTree {
   
    private Node root;
    private int nodeCount = 0;

    // Constructor for the class
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Get root
     * @return root of BST
     */
    public Node getRoot() {
        return root;
    }

    /** 
     * Get node cound
     * @return node count
     */
    public int getNodeCount() {
        return nodeCount;
    }

    /** 
     * Insert a node in the BST
     * @param Node node, int key
     */
    public void insert(Node node, int key) {
        
        // Add to total count of nodes
        nodeCount++;

        // Find the parent
        Node parent = null;
        Node index = root;
        while (index != null) {
            parent = index;
            if (key < index.getKey()) 
                index = index.getLeft();
            else
                index = index.getRight();
        }

        // Insert child
        if (parent == null)
            root = new Node(key);
        else if (key < parent.getKey())
            parent.setLeft(new Node(key));
        else
            parent.setRight(new Node(key));
    }

    /** 
     * Preorder traversal of BST
     * @param Node root
     */
    public void preorderRec(Node root) {
        if (root == null)
            return;

        // Left side
        preorderRec(root.getLeft());

        // Right side
        preorderRec(root.getRight());
    }

    /** 
     * Find sum of all keys of BST
     * @param Node root
     * @return sum of all keys
     */
    public int sum(Node root) {
        if (root == null)
            return 0;
        else
            return root.getKey() + sum(root.getLeft()) + sum(root.getRight());
    }

    /** 
     * Find the k'th biggest element in BST
     * @param Node root, int input
     * @throws IndexOutOfBoundsException if input too large
     * @return kth-biggest node of BST
     */
    public Node kthBiggest(Node root, int input) throws IndexOutOfBoundsException {
        if (input > (getNodeCount() + 1)) {
            System.out.println("Index out of range");
            throw new IndexOutOfBoundsException();
        }
        
        // Initialize an array list of Nodes
        List<Node> reverseList = new ArrayList<>();

        reverseInord(root, reverseList);
        
        return reverseList.get(getNodeCount() - input + 1);
    }

    /** 
     * Private method, computes reverse inorder
     * @param Node root, List<Node> reverseList
     */
    private void reverseInord(Node root, List<Node> reverseList) {
        if (root == null)
            return;
        
        // Left side
        reverseInord(root.getLeft(), reverseList);

        // Current node
        reverseList.add(root);

        // Right side
        reverseInord(root.getRight(), reverseList);
    }
 }