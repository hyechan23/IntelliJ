package Theme6_2;


public class Chaining <K, V>{
    private int M = 13;
    private Node[] a = new Node[M];
    public static class Node {
        private Object data;
        private Node next;
        private Object key;
        public Node(Object newdata, Node ref, Object newkey) {
            key = newkey;
            next = ref;
            data = newdata; // test
        }
        public Object getData() {return data;}
        public Object getKey() {return key;}
        public Node getNext() {return next;}
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public V get(K key) {
        int i = hash(key);
        for (Node x = a[i]; x != null ; x = x.next) {
            if(key.equals(x.key)) return (V)x.data;
        }
        return null;
    }
    private void put(K key, V val) {
        int i = hash(key);
        for (Node x = a[i]; x != null ; x = x.next) {
            if(key.equals(x.key)) {
                x.data = val;
                return;
            }
        } // ee
        // a[i] = new Node(key, data, a[i]);
    }
}
