import java.io.Serializable;
import java.util.ArrayList;

/***
 * Binary Search Tree Class
 * @param <E> Type of tree.
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>{
    // Data Fields
    /** Return value from the public add method. */
    protected boolean addReturn;
    /** Return value from the public delete method. */
    protected E deleteReturn;
    /**
     * The root of the binary tree
     */
    int root = 0;
    ArrayList<E> tree = new ArrayList<E>(20);
    /**
     * No parameter constructor initialize root to null.
     */
    public BinarySearchTree() {
        root = 0;
    }
    /**
     * One parameter constructor initialize root of tree.
     * @param root root of the tree.
     */
    protected BinarySearchTree(E data) {
        
       tree.add(data);
    }
    
    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinarySearchTree<E> getLeftSubtree() {
        if (tree.get(root) != null && tree.get(2*root +1) != null) {
            return new BinarySearchTree<E>(tree.get(2*root + 1));
        } else {
            return null;
        }
    }
    /** Return the right subtree.
     @return The right subtree or null if either the root or
     the right subtree is null
     */
    public BinarySearchTree<E> getRightSubtree() {
        if (tree.get(root) != null && tree.get(2*root +1) != null) {
            return new BinarySearchTree<E>(tree.get(2*root + 2));
        } else {
            return null;
        }
    }
    /** Determine whether this tree is a leaf.
     @return true if the root has no children
     */
    public boolean isLeaf() {
        return (tree.get(2*root +1) == null && tree.get(2*root + 2) == null);
    }
    /** Starter method find.
     pre: The target object must implement
     the Comparable interface.
     @param target The Comparable object being sought
     @return The object, if found, otherwise null
     */
    public E find(E target) {
        return find(root, target);
    }
    /** Recursive find method.
     @param localRoot The local subtree's root
     @param target The object being sought
     @return The object, if found, otherwise null
     */
    private E find(int localRoot, E target) {
        if (tree.get(localRoot) == null)
            return null;
        int compResult = target.compareTo(tree.get(localRoot));
        if (compResult == 0)
            return tree.get(localRoot);
        else if (compResult < 0)
            return find(2*localRoot + 1, target);
        else
            return find(2*localRoot + 2, target);
    }
    /** Starter method add.
     pre: The object to insert must implement the
     Comparable interface.
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exists in the tree
     */
    public boolean add(E item) {
        tree.add(root,add(root, item));
        return addReturn;
    }

    /**
     * Returns true if target is found in the tree.
     * @param target element will be searched.
     * @return true if target is found
     */
    @Override
    public boolean contains (E target) {
        return find (target) != null;
    }

    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private E add(int localRoot, E item) {
        if (tree.get(localRoot) == null) {
            addReturn = true;
            return tree.get(root);
        } else if (item.compareTo(tree.get(localRoot)) == 0) {
            addReturn = false;
            return tree.get(localRoot);
        } else if (item.compareTo(tree.get(localRoot)) < 0) {
            tree.add(2*localRoot + 1,add(2*localRoot +1, item));
            return tree.get(localRoot);
        } else {
            tree.add(2*localRoot + 2,add(2*localRoot + 2, item));
            return tree.get(localRoot);
        }
    }
    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E delete(E target) {
        tree.add(root,delete(root, target));
        return deleteReturn;
    }

    /**
     * Removes target (if found) from tree and returns true; otherwise, returns false.
     * @param target element will be removed.
     * @return if found returns true; otherwise, returns false.
     */
    @Override
    public boolean remove (E target) {
        return delete (target) != null;
    }

    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private E delete(int localRoot, E item) {
        if (tree.get(localRoot) == null) {
            deleteReturn = null;
            return tree.get(localRoot);
        }
        // Search for item to delete.
        int compResult = item.compareTo(tree.get(localRoot));
        if (compResult < 0) {
        // item is smaller than localRoot.data.
            tree.add(2*localRoot + 1,delete(2*localRoot+1, item));
            return tree.get(localRoot);
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            tree.add(2*localRoot + 2,delete(2*localRoot + 2, item));
            return tree.get(localRoot);
        } else {
            // item is at local root.
            deleteReturn = tree.get(localRoot);
            if (tree.get(2*localRoot + 1) == null) {
                    // If there is no left child, return right child
                // which can also be null.
                return tree.get(2*localRoot + 2);
            } else if (tree.get(2*localRoot + 2) == null) {
                // If there is no right child, return left child.
                return tree.get(2*localRoot + 1);
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (tree.get(2*(2*localRoot + 1) + 2) == null) {
                // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    tree.add(localRoot,tree.get(2*localRoot + 1));
                        // Replace the left child with its left child.
                        tree.add(2*localRoot + 1,tree.get(2*(2*localRoot + 1) + 1));
                    return tree.get(localRoot);
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    tree.add(localRoot,findLargestChild(2*localRoot + 1));
                    return tree.get(localRoot);
                }
            }
        }
    }
    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    protected E findLargestChild(int parent) {
            // If the right child has no right child, it is
            // the inorder predecessor.
        if (tree.get(2*(2*parent + 2) + 2) == null) {
            E returnValue = tree.get(2*parent + 2);
            tree.add(2*parent + 2, tree.get(2*(2*parent + 1) +2));
            return returnValue;
        } else {
            return findLargestChild(2* parent + 2);
        }
    }
}