package Theme4_1;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;
    public BinaryTree() {root = null;}
    public Node getRoot() {return root;}
    public void setRoot(Node root) {this.root = root;}
    public boolean isEmpty() {return root == null;}
    public void preorder(Node n) {
        if(n != null) {
            System.out.print(n.getKey() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }
    public void inorder(Node n) {
        if(n != null) {
            inorder(n.getLeft());
            System.out.print(n.getKey() + " ");
            inorder(n.getRight());
        }
    }
    public void postorder(Node n) {
        if(n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getKey() + " ");
        }
    }
    public void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Node t;
        q.add(root);
        while(!q.isEmpty()) {
            t = q.remove();
            System.out.print(t.getKey() + " ");
            if(t.getLeft() != null) {
                q.add(t.getLeft());
            }
            if(t.getRight() != null) {
                q.add(t.getRight());
            }
        }
    }
    public int size(Node n) {
        if(n == null) return 0;
        else return 1 + size(n.getLeft()) + size(n.getRight());
    }
    public int height(Node n) {
        if(n == null) return 0;
        else return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }
    public static boolean isEqual(Node n1, Node n2) {
        if(n1==null || n2 == null) return n1==n2;
        if(n1.getKey().compareTo(n2.getKey()) != 0) return false;
        return (isEqual(n1.getLeft(), n2.getLeft()) &&
                isEqual(n1.getRight(), n2.getRight()));
    }
}
