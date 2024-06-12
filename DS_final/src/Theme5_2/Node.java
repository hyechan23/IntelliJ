package Theme5_2;

public class Node<Key extends Comparable<Key>, Value> {
    private Key id;
    private Value name;
    private int height;
    private Node left, right;
    public Node(Key newId, Value newName, int newHt) {
        id = newId;
        name = newName;
        height = newHt;
        left = right = null;
    }
    public Node getLeft() {return left;}
    public Node getRight() {return right;}
    public Key getId() {return id;}
    public Value getName() {return name;}
    public int getHeight() {return height;}
    public void setHeight(int newHeight) {height = newHeight;}
    public void setName(Value newName) {name = newName;}
    public void setLeft(Node newLeft) {left = newLeft;}
    public void setRight(Node newRight) {right = newRight;}

}
