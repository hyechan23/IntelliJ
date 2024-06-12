package Theme4_1;

public class Node<Key extends Comparable<Key>> {
    private Key item;
    private Node<Key> left, right;
    public Node(Key newitem, Node lt, Node rt) {
        item = newitem; left = lt; right = rt;
    }
    public Key getKey() {return item;}
    public Node<Key> getLeft() { return left; }
    public Node<Key> getRight() { return right; }
    public void setKey(Key newitem) {item = newitem;}
    public void setLeft(Node<Key> lt) {left = lt;}
    public void setRight(Node<Key> rt) {right = rt;}
}
