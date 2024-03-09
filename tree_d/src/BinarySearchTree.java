import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private BSTNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private BSTNode<T> insertRecursive(BSTNode<T> current, T data) {
        // Base case: Empty tree or found insertion point
        if (current == null) {
            return new BSTNode<>(data);
        }

        // Recursive insertion depending on BST property
        if (data.compareTo(current.data) < 0) {
            current.left = insertRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRecursive(current.right, data);
        } else {
            // Duplicate elements - you could handle this differently if needed
            return current;
        }

        return current;
    }

    public void pre_order(BSTNode<T> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            pre_order(root.left);
            pre_order(root.right);
        }
    }

    public void post_order(BSTNode<T> root) {
        if (root != null) {
            post_order(root.left);
            post_order(root.right);
            System.out.print(root.data + " ");
        }
    }

    public BSTNode<T> getRoot(){
        return root;
    }

    public BSTNode<T> search(BSTNode<T> root, T searchValue) {
        if (root == null || root.data.equals(searchValue)) {
            return root; // Found or empty tree
        }

        if (searchValue.compareTo(root.data) < 0) {
            return search(root.left, searchValue); // Search in left subtree
        } else {
            return search(root.right, searchValue); // Search in right subtree
        }
    }
}