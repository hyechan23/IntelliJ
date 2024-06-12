package Theme5_2;

public class AVLTree <Key extends Comparable<Key>, Value> {
    Node root;

    public void put(Key k, Value v) {root = put(root, k, v);}
    private Node put(Node n, Key k, Value v) {
        if (n == null) return new Node(k, v, 1);
        int t = k.compareTo((Key)n.getId());
        if (t < 0) n.setLeft(put(n.getLeft(), k, v));
        else if (t > 0) n.setRight(put(n.getRight(), k, v));
        else {
            n.setName(v);
            return n;
        }
        n.setHeight(tallerHeight(n.getLeft().getHeight(), n.getRight().getHeight()));
        return n;
    }

    private Node rotateRight(Node n) {
        Node x = n.getLeft();
        n.setLeft(x.getRight());
        x.setRight(n);

        n.setHeight(tallerHeight(n.getLeft().getHeight(), n.getRight().getHeight()));
        x.setHeight(tallerHeight(n.getRight().getHeight(), n.getLeft().getHeight()));
        return x;
    }
    private Node rotateLeft(Node n) {
        Node x = n.getRight();
        n.setRight(x.getLeft());
        x.setLeft(n);
        n.setHeight(tallerHeight(n.getLeft().getHeight(), n.getRight().getHeight()));
        x.setHeight(tallerHeight(n.getLeft().getHeight(), n.getRight().getHeight()));
        return x;
    }

    private Node balance(Node n) {
        if (bf(n) > 1) {
            if(bf(n.getLeft()) < 0) {
                n.setLeft(rotateLeft(n.getLeft()));
            }
            n = rotateRight(n);
        }
        else if (bf(n) < -1) {
            if(bf(n.getRight()) > 0) {
                n.setRight(rotateRight(n.getRight()));
            }
            n = rotateLeft(n);
        }
        return n;
    }

    private int height(Node n) {
        if (n == null) return 0;
        return n.getHeight();
    }

    private int bf(Node n) {
        return n.getLeft().getHeight() - n.getRight().getHeight();
    }

    private int tallerHeight(int height, int height1) {
        if (height > height1) return height;
        else return height1;
    }
    public Key min() {
        if(root == null) return null;
        return (Key)min(root).getId();
    }
    private Node min(Node n) {
        if(n.getLeft()==null) return n;
        return min(n.getLeft());
    }
    public Node deleteMin(Node n) {
        if(n.getLeft() == null) return n.getRight();
        n.setLeft(deleteMin(n.getLeft()));
        return balance(n);
    }
    public void delete(Key k) {
        root = delete(root, k);
    }
    public Node delete(Node n, Key k) {

        if(n==null) return null;
        int t = n.getId().compareTo(k);
        if(t>0) {
            n.setLeft(delete(n.getLeft(), k));
        }
        else if(t<0) {
            n.setRight(delete(n.getRight(), k));
        }
        else {
            if(n.getRight()==null) return n.getLeft();
            if(n.getLeft() ==null) return n.getRight();
            Node target = n;
            n = min(target.getRight());
            n.setRight((deleteMin(target.getRight())));
            n.setLeft(target.getLeft());
        }
        n.setHeight(tallerHeight(height(n.getLeft()), height(n.getRight())) + 1);
        return balance(n);
    }
}
